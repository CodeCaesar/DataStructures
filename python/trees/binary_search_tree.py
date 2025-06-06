from binary_tree import BinaryTree


class _Node:
    
    key : int

    def __init__(self, key, data):
        self.key = key
        self.data = data
        self.parent = None
        self.left = None
        self.right = None

    def __repr__(self):
        return f"({self.left}) <-[{self.key}]-> ({self.right})"

class BinarySearchTree(BinaryTree):

    size : int
    root : _Node

    def __init__(self):
        super().__init__()
    
    def __insert(self, newNode):
        parent = None
        child = self.root

        while(child):
            parent = child

            if newNode.key < child.key:
                child = child.left
            else:
                child = child.right

        newNode.parent = parent

        if not parent:
            self.root = newNode
        elif newNode.key < parent.key:
            parent.left = newNode
        else:
            parent.right = newNode

    def insert(self, key, data):
        newNode = _Node(key, data)

        self.__insert(newNode)
        self.size += 1


BST = BinarySearchTree()
BST.insert(4, "first root")
BST.insert(2, "II")
BST.insert(7, "lucky")
BST.insert(3, "Python")
BST.insert(5, "V")
BST.insert(10, "X")
BST.insert(9, "3*3")

print(BST)
print(BST.height())

print("INORDER")
BST.inorder()
print("PREORDER")
BST.preorder()
print("POSTORDER")
BST.postorder()