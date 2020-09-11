def hanoiTower(n, src, dst, helper, S, D, H):
    """src, dest and helper are logical factors to inform the user
    what move they should take. S, D, H are lists that actually represent
    the poles. The values they store are rings. The bigger the number, the
    bigger size of the ring. The algorithm is optimal thus number of needed
    operations is 2^n - 1. With that said the while loop can be
    replaced with for loop"""
    for i in range(1, pow(2, n)):
        if i % 3 == 0:
            #if any pole is empty the ring can only be transported to that pole
            if len(H) == 0:
                H.append(D.pop())
                print("Move from", dst, "to", helper)
            elif len(D) == 0:
                D.append(H.pop())
                print("Move from", helper, "to", dst)

            #otherwise check which ring is bigger and add another ring there
            elif len(H) != 0 and len(D) != 0:
                if H[len(H)-1] > D[len(D)-1]:
                    H.append(D.pop())
                    print("Move from", dst, "to", helper)
                else:
                    D.append(H.pop())
                    print("Move from", helper, "to", dst)
                    
        elif i % 3 == 1:
            #if any pole is empty the ring can only be transported to that pole
            if len(S) == 0:
                S.append(D.pop())
                print("Move from", dst, "to", src)
            elif len(D) == 0:
                D.append(S.pop())
                print("Move from", src, "to", dst)

            #otherwise check which ring is bigger and add another ring there
            elif len(S) != 0 and len(D) != 0:
                if S[len(S)-1] > D[len(D)-1]:
                    S.append(D.pop())
                    print("Move from", dst, "to", src)
                else:
                    D.append(S.pop())
                    print("Move from", src, "to", dst)
                    
        elif i % 3 == 2:
            #if any pole is empty the ring can only be transported to that pole
            if len(H) == 0:
                H.append(S.pop())
                print("Move from", src, "to", helper)
            elif len(S) == 0:
                S.append(H.pop())
                print("Move from", helper, "to", src)

            #otherwise check which ring is bigger and add another ring there
            elif len(H) != 0 and len(S) != 0:
                if H[len(H)-1] > S[len(S)-1]:
                    H.append(S.pop())
                    print("Move from", src, "to", helper)
                else:
                    S.append(H.pop())
                    print("Move from", helper, "to", src)

        #print actual state      
        print(src, end ='')
        print(":", S)
        print(dst, end = '')
        print(":", D)
        print(helper, end = '')
        print(":", H)
        

#n = 5


A = []
B = []
C = []

for i in range(1, n+1):
    A.append(n+1-i)


print("Initial state:")
print("A:", A)
print("B:", B)
print("C:", C)


if n%2 != 0:
    hanoiTower(n, 'A', 'C', 'B', A, C, B)
else:
    hanoiTower(n, 'A', 'B', 'C', A, B, C)

print("Number of all moves:", pow(2, n) - 1)
