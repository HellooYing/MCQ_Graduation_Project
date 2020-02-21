from django.http import HttpResponse
from django.shortcuts import render
import json
from app.utils import *
import requests
from .models import *

def doMonitor(request):
    a=request.POST
    result={}
    result['post']=a
    return HttpResponse(json.dumps(result),content_type="application/json")

def registeredPi(request):
    response = HttpResponse()
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