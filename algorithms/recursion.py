

'''
import time
def countdown(i):
    print(i)
    time.sleep(0.2)
    if i == 0:
        return 0
    else:
        countdown(i-1)

countdown(10)
'''

def greet(name):
    print("Hello, "+name+"!")
    greet2(name)
    print("Preparing for a good bye")
    bye()

def greet2(name):
    print("How are you, "+name+"?")

def bye():
    print("Ok, see you later!")

greet("Simon")
