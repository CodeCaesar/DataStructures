from binary_tree import BinaryTree
from colours import Colours


class _Node:
    
    key : int
    colour : Colours

    def __init__(self, key, data, colour=Colours.RED):
        self.key = key
        self.data = data
        self.parent = None
        self.left = None
        self.right = None
        self.colour = colour

    def __repr__(self):
        return f"({self.left}) <-[{self.key}:{self.colour.value}]-> ({self.right})"

class RedBlackTree(BinaryTree):

    size : int
    root : _Node

    def __init__(self):
        super().__init__()