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

class BinaryTree:
    
    root : _Node
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