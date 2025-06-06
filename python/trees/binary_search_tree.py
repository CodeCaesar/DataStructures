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
    
    def __getNode(self, key):
        current = self.root

        while current and key != current.key:
            if(key < current.key):
                current = current.left
            else:
                current = current.right

        if current.key == key:
            return current
        else:
            return None
    
    def __min(self, current):
        while current.left:
            current = current.left

        return current
    
    def __transplant(self, removed_node, transplanted_node):
        if not removed_node.parent:
            self.root = transplanted_node
        elif removed_node == removed_node.parent.left:
            removed_node.parent.left = transplanted_node
        else:
            removed_node.parent.right = transplanted_node

        if transplanted_node:
            transplanted_node.parent = removed_node.parent

    def delete(self, key):
        delete_node = self.__getNode(key)

        if not delete_node:
            return

        if not delete_node.left:
            self.__transplant(delete_node, delete_node.right)
        elif not delete_node.right:
            self.__transplant(delete_node, delete_node.left)
        else:
            successor = self.__min(delete_node.right)

            if successor.parent != delete_node:
                self.__transplant(successor, successor.right)
                successor.right = delete_node.right
                successor.right.parent = successor

            self.__transplant(delete_node, successor)
            successor.left = delete_node.left
            successor.left.parent = successor

        self.size -= 1


BST = BinarySearchTree()
BST.insert(4, "first root")
BST.insert(2, "II")
BST.insert(7, "lucky")
BST.insert(3, "Python")
BST.insert(5, "V")
BST.insert(10, "X")
BST.insert(9, "3*3")
BST.delete(4)

print(BST)
#print(BST.height())

#print("INORDER")
#BST.inorder()
#print("PREORDER")
#BST.preorder()
#print("POSTORDER")
#BST.postorder()