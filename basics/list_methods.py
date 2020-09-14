#This program demonstrates most important list methods


stuff = ['pizza', 17.4, 'program', 'router', -8]
print(stuff)

#adds element at the end of the list
stuff.append('water')
print(stuff)

#returns the number of a spcified element
print(stuff.count('pizza')) #1
stuff.append('pizza')
print(stuff.count('pizza')) #2

#creates a copy of the list
stuff_copy = stuff.copy()
print(stuff_copy)

#returns the index of first specified element
print(stuff.index('pizza')) #0
print(stuff.index(17.4)) #1

#adds element at a spcified position
stuff.insert(1, 'pizza')
print(stuff)

#returns and removes elment at specified position
print(stuff.pop(len(stuff)-1)) #removes last element
print(stuff) 

#reverses the order of the list
stuff.reverse()
print(stuff)

input("Press enter to stop the program..")
