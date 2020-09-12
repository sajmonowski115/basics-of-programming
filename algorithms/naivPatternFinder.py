"""
This program is an example of a naiv looking for pattern algorithm.
In our case the pattern is two-dimensional and we try to find it
in a matrix of hexadecimal digits
"""

import time

def findPattern(file, number):
    """Finding a given pattern"""

    #open the file and work on it
    with open(file, 'r') as f:
        lst = []
        for line in f: #store lines in a list without /n symobl
            line = line[:-1]
            lst.append(line)

    #create list of lists to operate easly in two dimensions
    lstReady = []
    for element in lst:
        lstReady.append(list(element))

    #double pop to get rid of two extra empty lists created meanwhile
    lstReady.pop() 
    lstReady.pop()

    #attention: ancommenting the belowe code allows to see the list
    #however be aware that the size of the list is usually enormous
    #print(lstReady)
    

    counter = 0

    start = time.time()

    #algorithm for finding the pattern
    for i in range(len(lstReady)-2):
        for j in range(len(lstReady[i])-2):
            flag = True #settle true and check conditions
            if lstReady[i][j] != 'A':
                flag = False
            if lstReady[i][j+1] != 'B':
                flag = False
            if lstReady[i][j+2] != 'C':
                flag = False
            if lstReady[i+1][j] != 'B':
                flag = False
            if lstReady[i+2][j] != 'C':
                flag = False
            if flag: #if conditions met new repetition of pattern found
                counter += 1

    end = time.time()

    excTime = end - start

    print("For matrix of", number, "elements")
    print("The pattern has occured:", counter, "times")
    print("Process of finding pattern lasted:", excTime)
    print('\n')

def main():
    findPattern('1000_pattern.txt', 1000)
    findPattern('2000_pattern.txt', 2000)
    findPattern('3000_pattern.txt', 3000)
    findPattern('4000_pattern.txt', 4000)
    findPattern('5000_pattern.txt', 5000)
    #findPattern('8000_pattern.txt', 8000)

    input("Press eneter to continue..")
    
main()
