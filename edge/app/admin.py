from django.contrib import admin
from .models import ResponseDevice,Sensor,Monitor

admin.site.register(ResponseDevice)
admin.site.register(Sensor)
admin.site.register(Monitor)