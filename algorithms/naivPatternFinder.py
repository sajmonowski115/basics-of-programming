"""
This program is an example of Rabin-Karp algorithm. The pattern we're
finding here is two dimensional. However to ease the problem we can
with not much effort treanform the situation into lenear.
"""

"""
NOTE:
While exectuing the program there are created enormous lists. This may lead
to a memory error especially on py 32-bit version. 64bit-version recommened.
"""

def hashL(lst):
    """Converting five element list into a specific code"""

    key = 0

    for element in lst:
        key += ord(element)

    key += (ord(lst[0])%7) 
    key -= (ord(lst[1])%11)
    key += (ord(lst[2])%13)
    key -= (ord(lst[3])%17)
    key += (ord(lst[4])%19)
    
    return key

def prepareList(file):
    """create list of lists to operate easly in two dimensions"""

    #open the file and work on it
    with open(file, 'r') as f:
        lst = []
        for line in f:
            line = line[:-1]
            lst.append(line)

        lstReady = []
        for element in lst:
            lstReady.append(list(element))

        #triple pop to get rid of three extra empty lists created meanwhile
        lstReady.pop()
        lstReady.pop()
        lstReady.pop()

        #attention: ancommenting the belowe code allows to see the list
        #however be aware that the size of the list is usually enormous
        #print(lstReady)

    return lstReady

import time

def findPattern(file, number):

    lstReady = prepareList(file)

    lstFH = []

    #pattern we're looking for
    pattern = ['A', 'B', 'C', 'B', 'C']

    #store the hash value of our pattern
    value = hashL(pattern)

    #create five element lists to compare easly to the pattern
    for i in range(len(lstReady)-2):
        for j in range(len(lstReady[i])-2):
            tempLst = []
            tempLst.append(lstReady[i][j])
            tempLst.append(lstReady[i][j+1])
            tempLst.append(lstReady[i][j+2])
            tempLst.append(lstReady[i+1][j])
            tempLst.append(lstReady[i+2][j])

            lstFH.append(tempLst)

        lstOfHash = []

    #free some memory from no longer needed list
    lstReady.clear()

    #get all hash values and store them in a list at according indexes
    for element in lstFH:
        lstOfHash.append(hashL(element))

    counter = 0

    start = time.time()

    #compare the lists only when hash values match
    for i in range(len(lstOfHash)):
        if lstOfHash[i] == value:
            flag = True
            if lstFH[i][0] != pattern[0]:
                flag = False
            if lstFH[i][1] != pattern[1]:
                flag = False
            if lstFH[i][2] != pattern[2]:
                flag = False
            if lstFH[i][3] != pattern[3]:
                flag = False
            if lstFH[i][4] != pattern[4]:
                flag = False
            if flag: #if conditions met new repetition of pattern found
                counter += 1

    end = time.time()

    excTime = end - start

    print("For matrix of", number, 'elements')
    print("The pattern has been found", counter, 'times')
    print("Process of finding pattern lasted:", excTime)
    print('\n')

def main():
    findPattern('1000_pattern.txt', 1000)
    findPattern('2000_pattern.txt', 2000)
    findPattern('3000_pattern.txt', 3000)
    findPattern('4000_pattern.txt', 4000)
    findPattern('5000_pattern.txt', 5000)
    #findPattern('8000_pattern.txt', 8000)

    input("Press enter to continue..")

main()

