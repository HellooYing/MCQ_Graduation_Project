#声音传感器
import RPi.GPIO as GPIO
import time

GPIO.setmode(GPIO.BOARD)
channel = 13
GPIO.setup(channel,GPIO.IN)

Prev = []
i=0
while i<=100:
    time.sleep(0.01)
    i=i+1
    Sig = GPIO.input(channel)
    if len(Prev) > 99:
        Avg = 0
        for A in Prev:
            Avg = Avg + A
        Avg = Avg / 100.00
        Prev = []
        if Avg==1:
            print("no voice")
        else:
            print("voice")
    else:
        Prev.append(Sig)
        time.sleep(0.0003)