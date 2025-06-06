from binary_tree import BinaryTree


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

class BinarySearchTree(BinaryTree):

    def __init__(self):
        super().__init__()


BST = BinarySearchTree()
BST.root = _Node(2, "")
BST.root.left = _Node(5, "")
BST.root.right = _Node(9, "")
BST.root.left.left = _Node(142, "")
BST.root.right.right = _Node(3, "")

print(BST)
print(BST.height())

print("INORDER")
BST.inorder()
print("PREORDER")
BST.preorder()
print("POSTORDER")
BST.postorder()