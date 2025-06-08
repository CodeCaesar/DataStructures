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
    
    def __leftRotate(self, new_right_child:_Node):
        new_parent = new_right_child.right
        new_right_child.right = new_parent.left

        if new_parent.left != self.nil:
            new_parent.left.parent = new_right_child

        new_parent.parent = new_right_child.parent

        if new_right_child.parent == self.nil:
            self.root = new_parent
        elif new_right_child == new_right_child.parent.left:
            new_right_child.parent.left = new_parent
        else:
            new_right_child.parent.right = new_parent

        new_parent.left = new_right_child
        new_right_child.parent = new_parent

    def __rightRotate(self, new_left_child:_Node):
        new_parent = new_left_child.left
        new_left_child.left = new_parent.right

        if new_parent.right != self.nil:
            new_parent.right.parent = new_left_child

        new_parent.parent = new_left_child.parent

        if new_left_child.parent == self.nil:
            self.root = new_parent
        elif new_left_child == new_left_child.parent.right:
            new_left_child.parent.right = new_parent
        else:
            new_left_child.parent.left = new_parent

        new_parent.right = new_left_child
        new_left_child.parent = new_parent
