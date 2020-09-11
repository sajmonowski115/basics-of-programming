class Node:
    """This class is a node in a tree. Yet, in fact, with a given root we can
    reach any other element of a tree or a subtree"""
    def __init__(self,key): 
        self.left = None
        self.right = None
        self.val = key

def insert(root,node):
    """This function adds given element to an existing tree. If the tree
    does not exist it will make the received node the root."""
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
    """function used to traverse the tree and store all its nodes to a
    list, in increasing order"""
    if root: 
        inorder(root.left, V)
        V.append(root.val)
        inorder(root.right, V)
    return V


def takeRoot():
    """Make sure the root value is proper"""
    flag = True
    while flag:
        try:
            val = float(input("Value of the root: "))
            if val % 0.5 == 0 and val % 1 != 0 and val > 0:
                flag = False
            else:
                print("Wrong value passed. Try again.")
        except:
            print("Wrong value passed. Try again.")

    root = Node(val)
    return root

def takeNode(rootVal):
    """Make sure the node value is proper based on the value of the root"""
    flag = True
    while flag:
        try:
            val = float(input("Value of next node: "))
            if round(val*100, 1) % 1 != 0:
                print("Wrong value passed. Try again.")
            elif abs((rootVal-val)) > 0.5:
                print("Wrong value passed. Try again.")
            else:
                flag = False
        except:
            print("Wrong value passed. Try again.")

    return val


def createTree(root):
    """Combines the above functions to create a proper bst"""
    flag = True
    while flag:
        try:
            l = int(input("How many nodes are in the tree: "))
            if l > 0:
                flag = False
            else:
                print("Must be positive. Try again.")
        except:
            print("Wrong value passed. Try again.")    
    V = []
    for i in range(l-1):
        val = takeNode(root.val)
        while val in V or val == root.val:
            print("Already in the tree.")
            val = takeNode(root.val)
        V.append(val)

    for val in V:
        insert(root, Node(val))

    return root


def takeIndex():
    """Check if the given by user value is proper"""
    flag = True
    while flag:
        try:
            l = int(input("Which tree to work on: "))
            if l > 0:
                flag = False
            else:
                print("Must be positive. Try again.")
        except:
            print("Wrong value passed. Try again.")

    return l

class Structure:
    """Store roots of all binary search trees as it own root, which is a list"""
    def __init__(self, length, trees):
        self.length = length
        self.trees = trees

    def show(self):
        """NOTE: this function uses inorder traversal, thus single tree is shown
        as a list of sorted values. I decided to use this method, for I found
        it easier to implement, clearer and more useful when implementing and
        checking other methods of the structure"""
        i = 1
        for tree in self.trees:
            V = []
            V = inorder(tree, V)
            print("Tree number ", i, ':', end = ' ')
            print(V)
            i += 1

    def INSERT(self):
        print("Inserting a new node in a tree.")
        n = takeIndex()
        if n > self.length:
            print("There is no such tree in the structure. Try again.")
            n = takeIndex()
        n -= 1
        val = takeNode(self.trees[n].val)
        V = []
        V = inorder(self.trees[n], V)
        while val in V:
            print("Already in the tree. Try again.")
            val = takeNode(self.trees[n].val)
        insert(self.trees[n], Node(val))

    def MINIMUM(self):
        print("Finding minimum value in a tree")
        n = takeIndex()
        if n > self.length:
            print("There is no such tree in the structure. Try again.")
            n = takeIndex()
        n -= 1
        V = []
        V = inorder(self.trees[n], V)
        print("Minimum value in the tree: ", V[0])

    def MAXIMUM(self):
        print("Finding maximum value in a tree")
        n = takeIndex()
        if n > self.length:
            print("There is no such tree in the structure. Try again.")
            n = takeIndex()
        n -= 1
        V = []
        V = inorder(self.trees[n], V)
        print("Maximum value in the tree: ", V[-1])

    def SEARCH(self):
        """find out whether a node exist in the structure"""
        flag = True
        while flag:
            try:
                val = float(input("Value of the node to find: "))
                if round(val*100, 1) % 1 != 0:
                    print("Wrong value passed. Try again.")
                else:
                    flag = False
            except:
                print("Wrong value passed. Try again.")
        
        for element in self.trees:
            V = []
            V = inorder(element, V)
            if val in V:
                return True
        return False

def createStructure():
    """Use createTree function to achive the structure"""
    flag = True
    while flag:
        try:
            n = int(input("How many trees are in the structure: "))
            if n > 0:
                flag = False
            else:
                print("Must be positive. Try again.")
        except:
            print("Wrong value passed. Try again.")
    trees = []
    rootValues = [0]
    for i in range(n):
        print("Tree number:", i+1)
        root = takeRoot()

        while root.val in rootValues or root.val < rootValues[i]:
            print("Already in the list or too small value")
            root = takeRoot()

        rootValues.append(root.val)
        t = createTree(root)
        trees.append(t)

    S = Structure(n, trees)

    return S
        
        

def main():

    S = createStructure()

    flag = True
    while flag:
        try:
            l = int(input("How many times repeat the operations: "))
            if l > 0:
                flag = False
            else:
                print("Must be positive. Try again.")
        except:
            print("Wrong value passed. Try again.")
    
    for i in range(l):
        S.show()
        S.INSERT()
        S.MINIMUM()
        S.MAXIMUM()

        flag = S.SEARCH()

        if(flag):
            print("There is such a node in the structure")
        else:
            print("No such node in the structure")
            
    print("After inserting:")
    S.show()

    input("Press eneter to continue..")

    return

main()
       
