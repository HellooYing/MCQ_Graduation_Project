#温湿度传感器（2）
import os
import time
def getTemperatureAndHumidity():
    output = os.popen('python getTemperatureAndHumidity1.py')
    s=output.read()
    while(s=="wrong"+"\n"):
        time.sleep(1)
        output = os.popen('python getTemperatureAndHumidity1.py')
        s=output.read()
        
    a=s.split("\n")
    b=a[0:2]
    return b

print(getTemperatureAndHumidity())

