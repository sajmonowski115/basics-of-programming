from math import sqrt #needed to count distance


#convert all city info into integer (indexes) and float (coordinates)
def convert(lst):

    lstMain = []

    for sublist in lst:

        lstTemp = sublist.split('\t')

        lstTemp[0] = int(lstTemp[0])
        lstTemp[1] = float(lstTemp[1])
        lstTemp[2] = float(lstTemp[2])
        
        lstMain.append(lstTemp)
        
    return lstMain


#calculate distance between two given vectors
def calculateDistance(startVec, destVec):

    x = pow(startVec[1] - destVec[1], 2) + pow(startVec[2] - destVec[2], 2)
    distance = sqrt(x)

    return distance

#find the city that is the closest to currently visited city
def findNearest(lst, current):

    smallest = 100000
    
    for city in lst:
        if city == current:
            continue
        else:
            distance = calculateDistance(current, city)
            if distance < smallest:
                smallest = distance
                bestNeigh = city
                
    return bestNeigh

#run the algorithm starting from a given city
def greedySingleSearch(lst, startCity):

    total = 0

    lstCopy = lst.copy()

    lstCopy.remove(startCity)

    nextToGo = findNearest(lstCopy, startCity)
    total += calculateDistance(startCity, nextToGo)
    lstCopy.remove(nextToGo)

    present = nextToGo

    leng = len(lstCopy)

    for i in range(leng):
        nextToGo = findNearest(lstCopy, present)
        total += calculateDistance(present, nextToGo)
        lstCopy.remove(nextToGo)
        present = nextToGo

    total += calculateDistance(startCity, present)

    return round(total, 2)

#use greedy algorith for all cities and find best option
def bestPath(lst):

    path = 10000

    for city in lst:
        
        lstCopy = lst.copy()

        currentPath = greedySingleSearch(lstCopy, city)

        if currentPath < path:
            path = currentPath

    return round(path, 2)


def main():

    with open("TSP.txt", 'r') as f:

        lst = []
        
        for line in f:
            lst.append(line[:-1])
    
    lst = convert(lst)

    #print cost of path for any city
    for city in lst:
        print(city[0], end = '. path cost: ')
        print(greedySingleSearch(lst, city))
        print()

    #cost best possible path
    print('Cost of best path:', bestPath(lst))
    
    input("\nPress enter to continue..")
    
main()








