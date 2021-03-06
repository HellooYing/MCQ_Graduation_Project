from django.urls import path

from . import views

urlpatterns = [
    path('doMonitor', views.doMonitor, name='doMonitor'),
    path('registeredPi', views.registeredPi, name='registeredPi'),
    path('addResponseDevice', views.addResponseDevice, name='addResponseDevice'),
    path('addSensor', views.addSensor, name='addSensor'),
]