#光敏电阻 亮度传感器
import RPi.GPIO as GPIO
import time

GPIO.setmode(GPIO.BOARD)
channel = 11
GPIO.setup(channel,GPIO.IN)
if GPIO.input(channel):
    print("no light")
else:
    print("light")