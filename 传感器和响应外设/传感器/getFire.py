#火焰传感器
import RPi.GPIO as GPIO
import time
GPIO.setmode(GPIO.BOARD)
channel = 3
GPIO.setup(channel, 1)

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
        print(Avg * 100)
    else:
        Prev.append(Sig)
        time.sleep(0.0003)