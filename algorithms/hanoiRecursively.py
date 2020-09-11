moves = 0 #global variable to count total number of moves

def towerOfHanoi(n , src, dest, helper, S, D, H):
    """src, dest and helper are logical factors to inform the user
    what move they should take. S, D, H are lists that actually represent
    the poles. The values they store are rings. The bigger the number, the
    bigger size of the ring."""
    global moves
    if n==1: 
        print("Move disk 1 from source",src,"to destination",dest)
        D.append(S.pop())
        moves += 1 #with every move increase by one

        #print actual state
        print(src, end ='')
        print(":", S)
        print(dest, end = '')
        print(":", D)
        print(helper, end = '')
        print(":", H)
        
        return

    #move tower of size n-1 from source to helper
    towerOfHanoi(n-1, src, helper, dest, S, H, D) 

    #move the largest element from source to destination
    print("Move disk",n,"from source",src,"to destination",dest)
    D.append(S.pop())
    moves += 1 #with every move increase by one

    #print actual state
    print(src, end ='')
    print(":", S)
    print(dest, end = '')
    print(":", D)
    print(helper, end = '')
    print(":", H)

    #move tower of size n-1 from helper to destination
    towerOfHanoi(n-1, helper, dest, src, H, D, S) 
          
#n=5

A = []
B = []
C = []

#fulfill source pole with given number of rings
for i in range(1, n+1):
    A.append(n+1-i)

print("Initial state:")
print("A:", A)
print("B:", B)
print("C:", C)

towerOfHanoi(n,'A', 'C', 'B', A, C, B)

print("Number of all performed moves:", moves)
