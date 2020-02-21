import socket
import requests
url="http://localhost:8080"

def get_host_ip():
    try:
        s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
        s.connect(('8.8.8.8', 80))
        ip = s.getsockname()[0]
    finally:
        s.close()
    return ip

def getResponseDeviceTypeName(id):
    payload={'id': id}
    r = requests.post(url+'/getResponseDeviceTypeName', data=payload)
    if r.status_code!=200 or r.text=='not found' or r.text=='failed':
        return 'failed'
    else:
        return r.text

def getResponseDeviceTypeId(name):
    payload={'name': name}
    r = requests.post(url+'/getResponseDeviceTypeId', data=payload)
    if r.status_code!=200 or r.text=='not found' or r.text=='failed':
        return 'failed'
    else:
        return r.text

def getSensorTypeName(id):
    payload={'id': id}
    r = requests.post(url+'/getSensorTypeName', data=payload)
    if r.status_code!=200 or r.text=='not found' or r.text=='failed':
        return 'failed'
    else:
        return r.text

def getSensorTypeId(name):
    payload={'name': name}
    r = requests.post(url+'/getSensorTypeId', data=payload)
    if r.status_code!=200 or r.text=='not found' or r.text=='failed':
        return 'failed'
    else:
        return r.text
