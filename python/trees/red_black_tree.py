class _Node:
    
    key : int

    def __init__(self, key, data, colour="Red"):
        self.key = key
        self.data = data
        self.parent = None
        self.left = None
        self.right = None
        self.colour = colour

    def __repr__(self):
        return f"({self.left}) <-[{self.key}:{self.colour}]-> ({self.right})"

class RedBlackTree(BinaryTree):

    size : int
    root : _Node

    def __init__(self):
        super().__init__()