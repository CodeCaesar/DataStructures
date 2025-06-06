class BinaryTree:
    
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

    def __height(self, current):
        if not current:
            return 0
        elif not current.left and not current.right:
            return 0

        return self.max_height(self.__height(current.left), self.__height(current.right)) + 1

    def height(self):
        return self.__height(self.root)

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