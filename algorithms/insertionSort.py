def ins_sort(lst):  #increasing order
    for j in range(1, len(lst)):
        key = lst[j]
        i = j-1
        while i >= 0 and lst[i] > key:
            lst[i+1] = lst[i]
            i = i-1
        lst[i+1] = key
    return lst

def ins_sort2(lst):  #decrasing order
    for j in range(1, len(lst)):
        key = lst[j]
        i = j-1
        while i >= 0 and lst[i] < key:
            lst[i+1] = lst[i]
            i = i-1
        lst[i+1] = key
    return lst

lst = [1, 4, -7, 2, 0, 13, 9]
lst2 = [18, 3, 19, -3, 0.5, 91.7, 3.3, -15]

print(ins_sort(lst))
print(ins_sort(lst2))

print(ins_sort2(lst))
print(ins_sort2(lst2))
