#烟雾传感器
import RPi.GPIO as GPIO
import time

def f():
    GPIO.setmode(GPIO.BOARD)
    channel = 15
    GPIO.setup(channel,GPIO.IN)
    i=0
    while i<=100:
        time.sleep(0.02)
        i=i+1
        r=GPIO.input(channel)
        if r==1:
            return r
    return 0
        