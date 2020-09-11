class Node: 
    def __init__(self,key): 
        self.left = None
        self.right = None
        self.val = key

def insert(root,node): 
    if root is None: 
        root = node 
    else: 
        if root.val < node.val: 
            if root.right is None: 
                root.right = node 
            else: 
                insert(root.right, node) 
        else: 
            if root.left is None: 
                root.left = node 
            else: 
                insert(root.left, node)

def inorder(root, V): 
    if root: 
        inorder(root.left, V)
        V.append(root.val)
        #print(root.val) 
        inorder(root.right, V)
    return V


def createTree(root):
    numberOfNodes = 20 # /2
    
    V = []
    for i in range(1, numberOfNodes+1):
            val = round(root.val - (i*0.01), 2)
            V.append(val)
            val = round(root.val + (i*0.01), 2)
            V.append(val)

    for val in V:
        insert(root, Node(val))

    return root

class Structure:
    def __init__(self, length, trees):
        self.length = length
        self.trees = trees

    def INSERT(self):
        n = random.randint(0, self.length-1)
        val = round(self.trees[n].val + random.randint(-30, 30)*0.01)
        insert(self.trees[n], Node(val))

    def MINIMUM(self):
        n = random.randint(0, self.length-1)
        V = []
        V = inorder(self.trees[n], V)
        minValue = V[0]

    def MAXIMUM(self):
        n = random.randint(0, self.length-1)
        V = []
        V = inorder(self.trees[n], V)
        maxValue = V[-1]

    def SEARCH(self):
        root = random.choice(self.trees)
        n = root.val
        val = round(root.val + random.randint(-30, 30)*0.01)
        for element in self.trees:
            V = []
            V = inorder(element, V)
            if val in V:
                return True
        return False

def createStructure(n):
    trees = []
    for i in range(n):
        rootVal = i + 0.5 #the values are: 1,5 | 2,5 | 3,5 ...
        root = Node(rootVal)
        t = createTree(root)
        trees.append(t)
    S = Structure(n, trees)

    return S
        
        
import time
import random

def measureTime(S, trees):
    """measure time of all operations separetly and show results"""
    print("data for", trees, "trees:")
    
    start = time.time()
    for i in range(100000):
        S.MINIMUM()
    end = time.time()
    executionTime = end - start
    print("Finding minimum value 100000 times lasted:", executionTime)

    start = time.time()
    for i in range(100000):
        S.MAXIMUM()
    end = time.time()
    executionTime = end - start
    print("Finding maximum value 100000 times lasted:", executionTime)

    start = time.time()
    for i in range(100000):
        S.INSERT()
    end = time.time()
    executionTime = end - start
    print("Inserting an element 100000 times lasted:", executionTime)

    start = time.time()
    for i in range(100):
        S.SEARCH()
    end = time.time()
    executionTime = end - start
    print("Searching for an element 100 times lasted:", executionTime)

def main():
    
    trees = 1000 #1,47 | 1,44 | 5,69 | 3,41
    S = createStructure(trees)
    measureTime(S, trees)

    trees = 2000 #1,47 | 1,51 | 3,97 | 4,44
    S = createStructure(trees)
    measureTime(S, trees)

    trees = 3000 #1,47 | 1,48 | 3,44 | 4,5
    S = createStructure(trees)
    measureTime(S, trees)
    
    trees = 4000 ##1,49 | 1,56 | 3,26 | 5
    S = createStructure(trees) 
    measureTime(S, trees)

    trees = 6000
    S = createStructure(trees) #1.5 | 1.49 | 3,01 | 6,15 
    measureTime(S, trees)

    trees = 8000
    S = createStructure(trees) #1,5 | 1,5 | 3 | 8,65
    measureTime(S, trees)

    trees = 10000 #1,51 | 1,51 | 3,16 | 11,09
    S = createStructure(trees)
    measureTime(S, trees)

    input("Press eneter to continue..")
    
    return

main()
