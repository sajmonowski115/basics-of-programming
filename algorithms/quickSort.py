def quicksort(lst):
    if len(lst) < 2:
        return lst
    else:
        pivot = lst[0]
        less = [i for i in lst[1:] if i <= pivot]
        greater = [i for i in lst[1:] if i > pivot]

        return quicksort(less) + [pivot] + quicksort(greater)

lst = [1,2,-4,17,8,9,3,-10,0]

print(quicksort(lst))



