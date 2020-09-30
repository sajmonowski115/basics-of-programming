# this module includes three class definitions
# Circle, Triangle, Square
# avaliable functions are: area and circuit

import math as m

class Circle:
    def __init__(self, radius=1):
        self.radius = radius

    def area(self): #round to avoid long numbers
        self.area = round(m.pi*(self.radius**2), 3)
        return self.area
        
    def circuit(self): #round to avoid long numbers
        self.circuit = round(2*m.pi*self.radius, 3) 
        return self.circuit

class Triangle:
    def __init__(self, a=1, b=1, c=1):
        if(a+b<=c or a+c<=b or b+c<=a): #in case triangle can't be created
            print("Such a triangle does not exist")
            self.a = None
            self.b = None
            self.c = None
            self.existence = False
        else:
            self.a = a
            self.b = b
            self.c = c
            self.existence = True

    def area(self): 
        if not self.existence: #in case triangle can't be created
            print("Incorrect object!")
        else:
            p = (self.a + self.b + self.c)/2
            self.area = m.sqrt(p*(p-self.a)*(p-self.b)*(p-self.c))
            return round(self.area, 3) #round to avoid longnumbers
        
    def circuit(self):
        if not self.existence: #in case triangle can't be created
            print("Incorrect object!")
        else:   
            self.circuit = self.a + self.b + self.c
            return self.circuit

class Square:
    def __init__(self, side=1):
        self.side = side

    def area(self):
        self.area = self.side*self.side
        return self.area

    def circuit(self):
        self.circuit = self.side*4
        return self.circuit


#creating class Circle object
C1 = Circle(10)

print(C1.radius)
print(C1.area())
print(C1.circuit())


#creating class Triangle object
T1 = Triangle(15, 6.5, 11)

print(T1.a, T1.b, T1.c)
print(T1.area())
print(T1.circuit())


#creating class Square object
S1 = Square(5)

print(S1.side)
print(S1.area())
print(S1.circuit())

input("Press enter to continue..")
