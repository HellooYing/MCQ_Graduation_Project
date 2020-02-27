# -*- coding: UTF-8 -*-
from django.http import HttpResponse
from django.shortcuts import render
import json
from app.utils import *
import requests
from .models import *
import sensor


piId=-1
warehouseId=-1

alive_monitor={}

def getWarehouseId():
    global warehouseId
    if warehouseId!=-1:
        return warehouseId
    pis=Pi.objects.all()
    warehouseId=-1
    for pi in pis:
        warehouseId=pi.warehouseId
    if warehouseId==-1:
        return -1
    else:
        return warehouseId

def getPiId():
    global piId
    if piId!=-1:
        return piId
    pis=Pi.objects.all()
    piId=-1
    for pi in pis:
        piId=pi.id
    if piId==-1:
        return -1
    else:
        return piId

def monitoring(monitor):
    global warehouseId
    while true:
        if monitor_id in alive:
            return
        func = eval('sensor.'+str(monitor.id)+'.f')
        result=func()
        sensorRecord=SensorDataRecord()
        sensorRecord.sensorId=monitor.sensorId
        sensorRecord.value=


        
        

def doMonitor(request):
    
    getPiId()
    getWarehouseId()
    global piId
    global warehouseId
    if piId==-1 or warehouseId==-1:
        print("边缘设备注册异常，边缘设备号与仓库号为空！请重新注册")

    monitor=request.POST.get("warehouseId")
    response = HttpResponse()
    response.status_code = 200
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
    print(Monitor.objects.all())
    response = HttpResponse()
    response.status_code = 200
    response.content = 'ok'
    return response

def registeredPi(request):
    response = HttpResponse()
    global warehouseId=request.POST.get("warehouseId")
    location=request.POST.get("location")
    pi=Pi()
    pi.warehouseId=warehouseId
    pi.location=location
    pi.url=get_host_ip()
    payload={'warehouseId': warehouseId,'location':location,'url':pi.url}
    r = requests.post(url+'/addPi', data=payload)
    if r.status_code==200 and r.text!='failed':
        pi.id=r.text
        global piId=pi.id
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
    typeId=getResponseDeviceTypeId(responseDeviceName)
    if typeId=='failed':
        response.status_code = 400
        response.content = '输入响应外设类型名错误，无此类型！'
        return response
    payload={'responseDeviceType':typeId,'warehouseId': warehouseId,'location':location,'piId':piId}
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
    typeId=getSensorTypeId(sensorName)
    if typeId=='failed':
        response.status_code = 400
        response.content = '输入传感器类型名错误，无此类型！'
        return response
    payload={'sensorType':typeId,'warehouseId': warehouseId,'location':location,'piId':piId}
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