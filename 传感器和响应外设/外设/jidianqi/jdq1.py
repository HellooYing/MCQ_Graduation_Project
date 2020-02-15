import RPi.GPIO as GPIO
 
channel = 29

GPIO.setmode(GPIO.BOARD)
GPIO.setwarnings(False)
GPIO.setup(channel, GPIO.OUT)

GPIO.output(channel, 1)