fit = False #global variable used by pack function to tell whether
#an object was packed or there was not enough place to pack it

import time #to measure how long it takes to run the algorithm

def pack(rect, knapsack):
    '''packs a given object (rectangle) to a knapsack, which is
    two-dimensional tab containing either ones or zeros'''

    global fit
    
    fit = False #initially we suppose the rect won't fit
    
    leng = rect[2] #third parameter of the list is length
    width = rect[1] #second parameter of the list is width
    stop = False #if element fits the variable stops the function
    
    for i in range(len(knapsack)):
        if stop: #if element found than stop the loop
            break
        for j in range(len(knapsack)):
            if stop: #if element found than stop the current iteration
                break
            flag = True #to check if element can be placed in the searched area
            if knapsack[i][j] == 0:
                try: #try will save us from reaching out of the knapsack
                    for k in range(leng):
                        for l in range(width):
                            try:
                                if knapsack[i+k][j+l] != 0:
                                    flag = False
                                    break
                            except:
                                flag = False
                                break
                except: #when we do reach out of the knapsack than there is
                    #not enough place to pack the object
                    flag = False
                    break
            else:
                flag = False #in case we did not find the place
            if flag == True: #if the place was find than put it in there
                #changes all zeros into ones which means the spots are taken
                for f in range(leng):
                        for g in range(width):
                            knapsack[i+f][j+g] = 1
                stop = True

    #exactly same loop but with length and width swapped which simulates
    #turning the object around
    if not stop:
        temp = leng
        leng = width
        width = temp

        for i in range(len(knapsack)):
            if stop:
                break
            for j in range(len(knapsack)):
                if stop:
                    break
                flag = True
                if knapsack[i][j] == 0:
                    try:
                        for k in range(leng):
                            for l in range(width):
                                try:
                                    if knapsack[i+k][j+l] != 0:
                                        flag = False
                                        break
                                except:
                                    flag = False
                                    break
                    except:
                        flag = False
                        break
                else:
                    flag = False
                if flag == True:
                    for f in range(leng):
                            for g in range(width):
                                knapsack[i+f][j+g] = 1
                    stop = True

    if stop: #if the algorithm has been stopped we found a place
        fit = True

    return knapsack

#to convert all data (id, size and so on) into integers
def convert(lst):

    lstMain = []

    for sublist in lst:

        lstTemp = []
        
        lstTemp.append(int(sublist[0]))
        lstTemp.append(int(sublist[1]))
        lstTemp.append(int(sublist[2]))
        lstTemp.append(int(sublist[3]))
        
        lstMain.append(lstTemp)
        
    return lstMain


def approxSolution(file, size):
    '''creates a density function which is worth divided by size and than
    sorts the list by its density'''

    #open the file
    with open(file, 'r') as file:

        knapSize = size
        
        file.readline()
        file.readline()

        lst = []

        #create ready to use list
        for line in file:
            data = line[:-1].split(',')
            lst.append(data)


    lst = convert(lst)

    knapsack = []
    tempBox = []

    start = time.time()
    
    #create a knapsack as a list of x lists with x values each,
    #initially filled with zeros
    for i in range(knapSize):
        for j in range(knapSize):
            tempBox.append(0)
        knapsack.append(tempBox.copy())
        tempBox.clear()

    #create the density value for each item
    for sublist in lst:
        field = sublist[1] * sublist[2]
        sublist.append(round(sublist[3]/field, 3))

    #sort the list by the density of subjects
    lst.sort(key = lambda x: x[4], reverse = True)

    totalValue = 0
    rects = []

    #pack the knapsack storing reached value and number of packed elements
    for rect in lst:
        knapsack = pack(rect, knapsack)
        if fit:
            totalValue += rect[3]
            rects.append(rect[0])

    #get the measured time
    end = time.time()
    executionTime = (end*10000- start*10000)

    #display results
    print("Results for matrix", str(size), "x", str(size))
    print("Number of all possible itmes:", len(lst))
    print("Number of packed itmes:", len(rects))
    print("Total value achived:", totalValue)
    print("Time of computation:", round(executionTime/10000, 5))
    print()

def main():
    #try every set of data given in the task
    approxSolution('packages20.txt', 20)
    approxSolution('packages100.txt', 100)
    approxSolution('packages500.txt', 500)
    approxSolution('packages1000.txt', 1000)

    input("Press enter to continue..")

main()
