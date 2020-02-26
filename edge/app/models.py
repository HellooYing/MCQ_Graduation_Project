from django.db import models

#python3 manage.py makemigrations
#python3 manage.py migrate

class ResponseDevice(models.Model):
    id = models.IntegerField('id',primary_key=True)
    responseDeviceName = models.CharField('响应外设类型名',max_length = 150,default = '')
    warehouseId = models.IntegerField('归属仓库id',default = 0)
    piId = models.IntegerField('树莓派id',default = 0)
    location = models.CharField('响应外设坐标',max_length = 150,default = '')
    extension = models.CharField('扩展字段',max_length = 150,default = '')
    def __str__(self):
        return str(self.responseDeviceName+self.id)
    class Meta:
        ordering = ["id"]
    

class Sensor(models.Model):
    id = models.IntegerField('id',primary_key=True)
    sensorName = models.CharField('传感器类型名',max_length = 150,default = '')
    warehouseId = models.IntegerField('归属仓库id',default = 0)
    piId = models.IntegerField('树莓派id',default = 0)
    location = models.CharField('响应外设坐标',max_length = 150,default = '')
    extension = models.CharField('扩展字段',max_length = 150,default = '')
    def __str__(self):
        return str(self.sensorName+self.id)
    class Meta:
        ordering = ["id"]
        
class Monitor(models.Model):
    id = models.IntegerField('id',primary_key=True)
    sensorId = models.IntegerField('传感器id',default = 0)
    responseDeviceList = models.CharField('响应设备列表',max_length = 150,default = '')
    time = models.CharField('执行时间表达式',max_length = 150,default = '10')
    emails = models.CharField('邮件通知组',max_length = 150,default = '')
    sync_num = models.IntegerField('从边缘设备批量同步监控数据的条数',default = 100)
    def __str__(self):
        return str('监控任务'+id+'传感器'+sensorId)
    class Meta:
        ordering = ["id"]
        
        
class Pi(models.Model):
    id = models.IntegerField('id',primary_key=True)
    warehouseId = models.IntegerField('归属仓库id',default = 0)
    location = models.CharField('坐标',max_length = 150,default = '')
    url = models.CharField('访问地址',max_length = 150,default = '')
    extension = models.CharField('扩展字段',max_length = 150,default = '')
    def __str__(self):
        return str(self.responseDeviceName+self.id)
    class Meta:
        ordering = ["id"]
    