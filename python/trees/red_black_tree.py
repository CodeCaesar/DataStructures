from binary_tree import BinaryTree
from colours import Colours


class _Node:
    
    key : int
    colour : Colours

    def __init__(self, key, data, colour=Colours.RED):
        self.key = key
        self.data = data
        self.colour = colour
        self.parent = None
        self.left = None
        self.right = None

    def __repr__(self):
        if self.left.key == 0 and self.left.data == None and self.left.colour == Colours.BLACK:
            leftString = "Nil"
        else:
            leftString = self.left

        if self.right.key == 0 and self.right.data == None and self.right.colour == Colours.BLACK:
            rightString = "Nil"
        else:
            rightString = self.right

        return f"({leftString}) <-[{self.key}:{self.colour.value}]-> ({rightString})"

class RedBlackTree(BinaryTree):

    size : int
    root : _Node
    nil = _Node(0, None, Colours.BLACK)

    def __init__(self):
        super().__init__()
        self.root = self.nil
    
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

    def __fixup(self, new_node:_Node):
        while(new_node.parent.colour == Colours.RED):
            if new_node.parent == new_node.parent.parent.left:
                self.__fixup_case_a(new_node)
            else:
                self.__fixup_case_b(new_node)

        self.root.colour = Colours.BLACK
    
    def __insert(self, new_node:_Node):
        parent = self.nil
        child = self.root

        while(child != self.nil):
            parent = child

            if new_node.key < child.key:
                child = child.left
            else:
                child = child.right

        new_node.parent = parent

        if parent == self.nil:
            self.root = new_node
        elif new_node.key < parent.key:
            parent.left = new_node
        else:
            parent.right = new_node

        self.__fixup(new_node)

    def insert(self, key:int, data):
        new_node = _Node(key, data)
        new_node.parent = self.nil
        new_node.left = self.nil
        new_node.right = self.nil

        self.__insert(new_node)
        self.size += 1
    
    def __valid_red_parent(self, parent:_Node):
        if parent == self.nil:
            return True
        elif parent.colour == Colours.BLACK:
            return self.__valid_red_parent(parent.left) and self.__valid_red_parent(parent.right)
        elif parent.left.colour == Colours.BLACK and parent.right.colour == Colours.BLACK:
            return True and self.__valid_red_parent(parent.left) and self.__valid_red_parent(parent.right)
        else:
            return False

    def __compare_black_depth(self, current:_Node):        
        if current.colour == Colours.BLACK:
            is_black = 1
        else:
            is_black = 0

        if current == self.nil:
            return 0
        elif current.left == self.nil and current.right == self.nil:
            return is_black
        
        left_depth = self.__compare_black_depth(current.left)

        if left_depth == self.__compare_black_depth(current.right):
            return is_black + left_depth
        else:
            return -1

    def __valid_black_depth(self, current:_Node):
        if current.left == self.nil and current.right == self.nil:
            return True
        elif self.__compare_black_depth(current) == -1:
            return False
        else:
            return True

    def valid(self):
        """
        Checks if Red-Black Tree is valid by checking following properties
        <li>1. Every node is either red or black</li>
        <li>2. Root is black</li>
        <li>3. Every leaf node is black</li>
        <li>4. If node is red then both its children are black</li>
        <li>5. Every path must have same black depth</li>

        Colours.java guarantees 1st property; nil field guarantees 3rd property. Thus this method only has to check 2nd, 4th and 5th property.
        """
        if self.root.colour == Colours.RED:
            return False
        elif not self.__valid_red_parent(self.root):
            return False
        elif not self.__valid_black_depth(self.root):
            return False
        else:
            return True


RBT = RedBlackTree()
RBT.insert(4, "first root")
RBT.insert(2, "II")
RBT.insert(7, "lucky")
RBT.insert(3, "Python")
RBT.insert(5, "V")
RBT.insert(10, "X")
RBT.insert(9, "3*3")

print(RBT)
print(RBT.valid())