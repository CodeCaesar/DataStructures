from binary_tree import BinaryTree
from colours import Colours


class _Node:
    
    key : int
    colour : Colours

    def __init__(self, key, data, colour=Colours.RED):
        self.key = key
        self.data = data
        self.parent = RedBlackTree.nil
        self.left = RedBlackTree.nil
        self.right = RedBlackTree.nil
        self.colour = colour

    def __repr__(self):
        return f"({self.left}) <-[{self.key}:{self.colour.value}]-> ({self.right})"

class RedBlackTree(BinaryTree):

    size : int
    root : _Node
    nil = _Node(0, None, Colours.BLACK)

    def __init__(self):
        super().__init__()