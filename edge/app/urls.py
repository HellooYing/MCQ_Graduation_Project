# -*- coding: UTF-8 -*-
from django.urls import path

from . import views

urlpatterns = [
    path('undoMonitor', views.undoMonitor, name='undoMonitor'),
    path('doMonitor', views.doMonitor, name='doMonitor'),
    path('addMonitor', views.addMonitor, name='addMonitor'),
    path('addPi', views.addPi, name='addPi'),
    path('addResponseDevice', views.addResponseDevice, name='addResponseDevice'),
    path('addSensor', views.addSensor, name='addSensor'),
]