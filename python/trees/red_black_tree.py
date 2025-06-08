from binary_tree import BinaryTree
from colours import Colours


class _Node:
    
    key : int
    colour : Colours

    def __init__(self, key, data, colour=Colours.RED):
        self.key = key
        self.data = data
        self.colour = colour
        self.parent = RedBlackTree.nil
        self.left = RedBlackTree.nil
        self.right = RedBlackTree.nil

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

    def __fixup_case_a(self, new_node:_Node):
        uncle = new_node.parent.parent.right

        if uncle.colour == Colours.RED: # CASE 1
            new_node.parent.colour = Colours.BLACK
            uncle.colour = Colours.BLACK
            new_node.parent.parent.colour = Colours.RED
            new_node = new_node.parent.parent
        else:
            if new_node == new_node.parent.right: # CASE 2
                new_node = new_node.parent
                self.__leftRotate(new_node)

            # CASE 2 & 3
            new_node.parent.colour = Colours.BLACK
            new_node.parent.parent.colour = Colours.RED
            self.__rightRotate(new_node.parent.parent)

    def __fixup_case_b(self, new_node:_Node):
        uncle = new_node.parent.parent.left

        if uncle.colour == Colours.RED: # CASE 1
            new_node.parent.colour = Colours.BLACK
            uncle.colour = Colours.BLACK
            new_node.parent.parent.colour = Colours.RED
            new_node = new_node.parent.parent
        else:
            if new_node == new_node.parent.left: # CASE 2
                new_node = new_node.parent
                self.__rightRotate(new_node)

            # CASE 2 & 3
            new_node.parent.colour = Colours.BLACK
            new_node.parent.parent.colour = Colours.RED
            self.__leftRotate(new_node.parent.parent)

    def fixup(self, new_node:_Node):
        while(new_node.parent.colour == Colours.RED):
            if new_node.parent == new_node.parent.parent.left:
                self.__fixup_case_a(new_node)
            else:
                self.__fixup_case_b(new_node)

        self.root.colour = Colours.BLACK