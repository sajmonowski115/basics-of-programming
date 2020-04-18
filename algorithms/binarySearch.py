# This program demonstrates a typical binary search
# author~ Szymon Bobrowski
# date: 24.03.2020

import random

def binary_search(LIST, item):
    low = 0
    high = len(LIST)-1
    tries = 0

    while low <= high:
        mid = int((low + high)/2)
        guess = LIST[mid]
        if guess == item:
            print("Number of tries:", tries)
            return mid
        if guess > item:
            high = mid - 1
        else:
            low = mid + 1
        tries += 1
    print("Number of tries:", tries)
    return None
    
'''
my_list = [1, 3, 5, 7, 9]

print(binary_search(my_list, 3))
print(binary_search(my_list, -1))
'''

GUESS = random.randint(1, 100)

print(GUESS)

my_list = []

for i in range(1, 101):
    my_list.append(i)

#print(my_list)

print(binary_search(my_list, GUESS)+1)

