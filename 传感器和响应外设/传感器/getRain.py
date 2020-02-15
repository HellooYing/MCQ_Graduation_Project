#雨滴传感器
import RPi.GPIO as GPIO
import time

GPIO.setmode(GPIO.BOARD)
channel = 5
GPIO.setup(channel,GPIO.IN)
if GPIO.input(channel):
    print("no rain")
else:
    print("rain")