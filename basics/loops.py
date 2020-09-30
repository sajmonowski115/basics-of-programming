#There are two types of loops in python: while loop and for loop


#the while loop continues as long as the condiotion is met
i=1
while i:
    i = int(input("0 to end the loop, 1 to continue the loop: "))
print("Loop has been left")


#iterating over elements of a list
lst = [3, 'java', True, -12.34, 'python']
for element in lst:
    print(element)

#iterating certain number of times
for i in range(2, 8):
    print(i)
