def greet(name):
    print("Hello", name + "!")
    print("Nice to see you again")

def add(a=0, b=0, c=0, d=0, e=0, f=0):
    return a+b+c+d+e+f


greet("Simon")

print(add(1, 1))
print(add(3, 1, 7))
print(add(11, 1, -5, 150, 13))
