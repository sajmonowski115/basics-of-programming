'''
def total(lst):
    total = 0
    for element in lst:
        total += element
    return total

lst = [1, 2, 3, 4]

print(total(lst))

#print(sum([1, 2, 3, 4]))
'''

'''
def total(lst):
    if lst == []:
        return 0
    return lst[0] + total(lst[1:])
        

lst = [1, 2, 3, 4, -2, 15]

print(total(lst))
'''

'''
def sizeOfList(lst):
    if lst == []:
        return 0
    return 1 + sizeOfList(lst[1:])

lst = [2, 7, '!', 12]

print(sizeOfList(lst))
'''

def maxValue(lst):
    if len(lst) == 1:
        return lst[0]
    if lst[0] > maxValue(lst[1:]):
        return lst[0]
    else:
        return maxValue(lst[1:])
    #return max(lst[0], maxValue(lst[1:]))

lst = [1000, 2502, 3, 255, -2, 10000, 15, 311]

print(maxValue(lst))


lst2 = []

try:
    print(maxValue(lst2))
except:
    print("Wrong list given to the funcion")








#
