import RPi.GPIO as GPIO
import time
 
trig=31
 
def init():
    GPIO.setwarnings(False)
    GPIO.setmode(GPIO.BOARD) 
    GPIO.setup(trig,GPIO.OUT,initial=GPIO.HIGH)
    pass
 
def beep(seconds):
    GPIO.output(trig,GPIO.LOW) 
    time.sleep(seconds)
    GPIO.output(trig,GPIO.HIGH) 
    
def beepBatch(seconds,timespan,counts):
    for i in range(counts):
        beep(seconds)
        time.sleep(timespan) 
        
init()
#beep(0.1)
beepBatch(0.1,0.3,30)
  
GPIO.cleanup()