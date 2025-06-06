class _Node:
    
    key :int

    def __init__(self, key, data):
        self.key = key
        self.data = data
        self.parent = None
        self.left = None
        self.right = None

    def __repr__(self):
        return f"({self.left}) <-[{self.key}]-> ({self.right})"

class BinaryTree:
    
    root : _Node
    size : int

    def __init__(self):
        self.root = None
        self.size = 0
    
    def __repr__(self):
        return f"{self.root}"

    def get_size(self):
        return self.size

    def get_root(self):
        return self.root.key
    
    def max_height(self, height1, height2):
        if height1 >= height2:
            return height1
        else:
            return height2    

    def height(self, current):
        if not current:
            return 0
        elif not current.left and not current.right:
            return 0

        return self.max_height(self.height(current.left), self.height(current.right)) + 1

    def height(self):
        return self.height(self.root)

    def __inorder(self, current):
        if current:
            self.__inorder(current.left)
            print(current.key)
            self.__inorder(current.right)
    
    def inorder(self):
        self.__inorder(self.root)

    def __preorder(self, current):
        if current:
            print(current.key)
            self.__preorder(current.left)
            self.__preorder(current.right)
    
    def preorder(self):
        self.__preorder(self.root)

    def __postorder(self, current):
        if current:
            self.__postorder(current.left)
            self.__postorder(current.right)
            print(current.key)
    
    def postorder(self):
        self.__postorder(self.root)


BT = BinaryTree()
BT.root = _Node(2, "")
BT.root.left = _Node(5, "")
BT.root.right = _Node(9, "")
BT.root.left.left = _Node(142, "")
BT.root.right.right = _Node(3, "")

print(BT)

print("INORDER")
BT.inorder()
print("PREORDER")
BT.preorder()
print("POSTORDER")
BT.postorder()