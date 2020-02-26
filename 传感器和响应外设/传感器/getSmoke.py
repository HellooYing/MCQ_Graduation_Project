#烟雾传感器
import RPi.GPIO as GPIO
import time

GPIO.setmode(GPIO.BOARD)
channel = 15
GPIO.setup(channel,GPIO.IN)

Prev = []
i=0
while i<=100:
    time.sleep(0.02)
    i=i+1
    Sig = GPIO.input(channel)
    if len(Prev) > 99:
        Avg = 0
        for A in Prev:
            Avg = Avg + A
        Avg = Avg / 100.00
        Prev = []
        if Avg==0:
            print("no smoke")
        else:
            print("smoke")
    else:
        Prev.append(Sig)
        time.sleep(0.0003)