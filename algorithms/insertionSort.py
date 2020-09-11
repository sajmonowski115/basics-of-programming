def insSort(lst):  #increasing order
    for i in range(1, len(lst)):
        key = lst[i] #currently checked
        j = i-1 #previous element
        
        #if currently checked element greater than previous element swap
        #keep swaping until currently checked element in right place
        while j >= 0 and lst[j] > key: 
            lst[j+1] = lst[j]
            j = j-1
        lst[j+1] = key
    return lst

import random #to create a list of random values
import time #to measure time


times = [] #here we store execution times

"""
NOTE:
Instead of using sequences with 10^5 values, I used 10^4. Firstly I tried
to measure the time for larger sequences, but my coputer could not
perform the opearation for 2 hours so I killed the program and used ten
times smaller sequences instead.
"""

for i in range(110):
    lst = []
    for j in range(10100):
        number = random.randint(0, 500)
        lst.append(number)
    start = time.time()
    insSort(lst)
    end = time.time()
    executionTime = end - start
    times.append(executionTime)

times.sort()

#measured results on the right
print("Best case:", times[0]) #4.477
print("Worst case:", times[len(times)-1]) #4.778 
print("Average time:", sum(times)/len(times)) #4.603


print("Total time:", sum(times)) #506.329

