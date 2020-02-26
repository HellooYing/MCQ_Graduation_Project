import RPi.GPIO as GPIO
 
GREEN = 19
YELLOW = 21
RED = 23

GPIO.setmode(GPIO.BOARD)
GPIO.setwarnings(False)
GPIO.setup(GREEN, GPIO.OUT)
GPIO.setup(YELLOW, GPIO.OUT)
GPIO.setup(RED, GPIO.OUT)

GPIO.output(RED, True)
GPIO.output(YELLOW, False)
GPIO.output(GREEN, True)