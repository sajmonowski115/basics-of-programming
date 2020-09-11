from math import sqrt #needed to count distance


#open the file and create a list of cities
with open("TSP.txt", 'r') as f:

    lst = []
    
    for line in f:
        lst.append(line[:-1])

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


lst = convert(lst)

#print(lst)

total = 0

#go from one city to another as in the file
for i in range(99):
    total += calculateDistance(lst[i], lst[i+1])

#come back to the starting city
total += calculateDistance(lst[99], lst[0])

print("Total distance:", round(total, 2))

input("\nPress eneter to continue..")
