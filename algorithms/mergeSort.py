def sortM(lst):
    """Takes a list and returns it sorted"""
    mergeSort(lst)
    return lst

def mergeSort(lst):
    """Includes the actual sorting"""
    if len(lst) == 1: #if only one element left return the element
        return lst
    else:
        middle = len(lst) // 2 #return the middle element or the left one of two middle elements

        L = lst[:middle] #take the left side of given list
        R = lst[middle:] #take the right side of given list

        mergeSort(L) #merge all sub-lists created on the left side comparing their values
        mergeSort(R) #merge all sub-lists created on the rigth side comparing their values

        """merging part"""
        
        k = 0 #to keep track of the index of merged list

        #merge two lists until one is empty
        while len(L) != 0 and len(R) != 0:
            if L[0] <= R[0]:
                lst[k] = L[0]
                L.remove(L[0])
            else:
                lst[k] = R[0]
                R.remove(R[0])
            k += 1

        #add any left elements from L in right order
        if len(L) != 0:
            for n in L:
                lst[k] = n
                k += 1

        #add any left elements from R in right order
        if len(R) != 0:
            for n in R:
                lst[k] = n
                k += 1

import random #to create a list of random values
import time #to measure time

times = [] #here we store execution times

for i in range(110):
    lst = []
    for j in range(100100):
        number = random.randint(0, 500)
        lst.append(number)
    start = time.time()
    mergeSort(lst)
    end = time.time()
    executionTime = end - start
    times.append(executionTime)

times.sort()

print("Best case:", times[0]) #2,621
print("Worst case:", times[len(times)-1]) #8,02
print("Average time:", sum(times)/len(times)) #4,718

print("Total time:", sum(times)) #518.98
