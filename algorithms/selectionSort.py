def findSmallest(lst):
    smallest = lst[0]
    smallest_index = 0
    for i in range(1, len(lst)):
        if lst[i] < smallest:
            smallest = lst[i]
            smallest_index = i
    return smallest_index

def selectionSort(lst):
    newLst = []
    for i in range(len(lst)):
        smallest = findSmallest(lst)
        newLst.append(lst.pop(smallest))
    return newLst

lst = [5, 3, 6, 2, 10, 0, -5, 19, 3.5]

print(selectionSort(lst))
