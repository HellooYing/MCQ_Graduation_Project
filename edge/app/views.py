# -*- coding: UTF-8 -*-
from django.http import HttpResponse
from django.shortcuts import render
import json
from app.utils import *
import requests
from .models import *
import sensor
import time
import _thread


piId=-1
warehouseId=-1

alive_monitor=[]

# 新建线程进行监控时的
def monitoring(monitor):
    print("启动监控线程，监控编号："+str(monitor.id))
    # 根据监控数值类型不同，定义不同的判别方式
    l=monitor.abnormal.split(',')
    # 类型1：异常表达式为"0"或"1"，当监控数据值为0或1时异常告警（isNormal函数返回false时代表不正常，要发出警告）
    # 如火焰传感器的异常表达式为1，即有火焰时不正常。
    if len(l)==1:
        def isNormal(value):
            if int(value)==int(monitor.abnormal):
                return False
            else:
                return True 
    # 类型2：形如"50,100"，则当监控数据值在50~100范围中时异常告警
    elif len(l)==2:
        def isNormal(value):
            if int(value)>=int(l[0]) and int(value)<=int(l[1]):
                return False
            else:
                return True
    # 类型3：异常形如"!,50,100",则值不在50-100范围内时异常告警
    # 如温度传感器的异常表达式为"!,20,30",则温度在20-30度时isNormal返回True即正常，不在20-30度时异常告警
    elif len(l)==3:
        def isNormal(value):
            if int(value)>=int(l[1]) and int(value)<int(l[2]):
                return True
            else:
                return False
    else:
        return False
    
    # 开始循环监控
    i=0
    while True:
        # 如果该监控的id不在"应运行的监控列表"中，则返回
        if monitor.id not in alive_monitor:
            print("终止监控"+str(monitor.id)+"成功")
            return
        # 举例：假设监控id是1，下面是执行sensor.m1.f()函数，将结果存到result中。
        func = eval('sensor.m'+str(monitor.id)+'.f')
        result=func()
        # 若f()返回失败则忽略本次执行，之所以这样写是因为传感器硬件可能经常返回奇怪的结果。
        # 如果后续有需要，可以计算硬件失败次数来避免硬件确实坏了一直返回不合法的值的情况，但暂时不作考虑。
        if result=='failed':
            continue
        # 记录这条监控数据
        sensorRecord=SensorDataRecord()
        sensorRecord.sensorId=monitor.sensorId
        sensorRecord.value=result
        sensorRecord.normal=isNormal(result)
        sensorRecord.save()
        # 如果这条数据的值是不正常的，则告警，并直接向云端发送数据
        if sensorRecord.normal==False:
            print('不正常')
            # 发邮件等操作，要做到一段时间只执行一次。
            #sendEmail(monitor.emails)
            #doResponse(monitor.responseDeviceList)
            # 若监控数据不正常，则直接提交数据
            r=submit(monitor)
            if r=='failed':
                print("提交监控数据失败，监控id："+str(monitor.id))
            else:
                i=0
                continue
        # 值正常则数据量+1，执行后续判断
        i=i+1
        # 若sync_num不为0，且数据量到达批量上传界限，则批量上传到云端
        if monitor.sync_num!=0:
            if i>=monitor.sync_num:
                r=submit(monitor)
                if r=='failed':
                    print("提交监控数据失败，监控id："+str(monitor.id))
                else:
                    i=0
        # 若sync_num为0，则默认不提交数据，一直正常的话每积累10000条正常数据清空一次
        else:
            if i>=10000:
                SensorDataRecord.objects.filter(sensorId=monitor.sensorId).delete()
                i=0
        time.sleep(int(monitor.time))

# 向服务器批量上传监控数据
def submit(monitor):
    data=SensorDataRecord.objects.filter(sensorId=monitor.sensorId)
    payload={'data': data}
    r = requests.post(url+'/submit', data=payload)
    if r.status_code==200 and r.text!='failed':
        SensorDataRecord.objects.filter(sensorId=monitor.sensorId).delete()
        return 'ok'
    else:
        return 'failed'

# 云端向边缘端发出指令：开始运行某监控
def doMonitor(request):
    monitorId=request.POST.get("id")
    monitor=Monitor.objects.get(id=monitorId)
    alive_monitor.append(int(monitor.id))
    try:
        _thread.start_new_thread( monitoring, (monitor, ))
    except:
        print ("Error: 无法启动线程")
    response = HttpResponse()
    response.status_code = 200
    response.content = 'ok'
    return response

def undoMonitor(request):
    monitorId=request.POST.get("id")
    response = HttpResponse()
    response.status_code = 200
    if int(monitorId) in alive_monitor:
        alive_monitor.remove(int(monitorId))
    response.content = 'ok'
    return response
    
def addMonitor(request):
    monitor=Monitor()
    monitor.id=request.POST.get('id')
    monitor.sensorId=request.POST.get('sensorId')
    monitor.responseDeviceList=request.POST.get('responseDeviceList')
    monitor.time=request.POST.get('time')
    monitor.emails=request.POST.get('emails')
    monitor.sync_num=request.POST.get('sync_num')
    monitor.save()
    response = HttpResponse()
    response.status_code = 200
    response.content = 'ok'
    return response

def addPi(request):
    response = HttpResponse()
    global warehouseId
    warehouseId=request.POST.get("warehouseId")
    location=request.POST.get("location")
    pi=Pi()
    pi.warehouseId=warehouseId
    pi.location=location
    pi.url=get_host_ip()
    payload={'warehouseId': warehouseId,'location':location,'url':pi.url}
    r = requests.post(url+'/addPi', data=payload)
    if r.status_code==200 and r.text!='failed':
        pi.id=r.text
        global piId
        piId=pi.id
        pi.save()
        response.status_code = 200
        response.content = 'ok'
        return response
    else:
        response.status_code = r.status_code
        response.content = 'fail'
        return response
    
def addResponseDevice(request):
    response = HttpResponse()
    pis=Pi.objects.all()
    piId=-1
    for pi in pis:
        piId=pi.id
    if piId==-1:
        response.status_code = 400
        response.content = '边缘设备未注册！无法在此边缘设备上添加响应外设'
        return response
    responseDeviceName = request.POST.get("responseDeviceName")
    warehouseId = request.POST.get("warehouseId")
    location = request.POST.get("location")
    rd=ResponseDevice()
    rd.responseDeviceName=responseDeviceName
    rd.warehouseId=warehouseId
    rd.piId=piId
    rd.location=location
    payload={'responseDeviceName':responseDeviceName,'warehouseId': warehouseId,'location':location,'piId':piId}
    r = requests.post(url+'/addResponseDevice', data=payload)
    if r.status_code==200 and r.text!='failed':
        rd.id=r.text
        rd.save()
        response.status_code = 200
        response.content = 'ok'
        return response
    else:
        response.status_code = r.status_code
        response.content = 'fail'
        return response
    
def addSensor(request):
    response = HttpResponse()
    pis=Pi.objects.all()
    piId=-1
    for pi in pis:
        piId=pi.id
    if piId==-1:
        response.status_code = 400
        response.content = '边缘设备未注册！无法在此边缘设备上添加传感器'
        return response
    sensorName = request.POST.get("sensorName")
    warehouseId = request.POST.get("warehouseId")
    location = request.POST.get("location")
    sensor=Sensor()
    sensor.sensorName=sensorName
    sensor.warehouseId=warehouseId
    sensor.piId=piId
    sensor.location=location
    payload={'sensorName':sensorName,'warehouseId': warehouseId,'location':location,'piId':piId}
    r = requests.post(url+'/addSensor', data=payload)
    if r.status_code==200 and r.text!='failed':
        sensor.id=r.text
        sensor.save()
        response.status_code = 200
        response.content = 'ok'
        return response
    else:
        response.status_code = r.status_code
        response.content = 'fail'
        return response