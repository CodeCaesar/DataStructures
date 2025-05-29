class _None:
    data: int
    next_node: _None

    def __self__(self, data):
        self.data = data
        self.next_node = None
    
    def __repr__(self):
        return f"(Data: {self.data}) -> {self.next_node}"

class SinglyLinkedList:

    head: _None
    tail: _None
    size: int

    def __self__(self):
        self.head = None
        self.tail = None
        self.size = 0
    
    def is_empty(self):
        return self.size == 0
    
    def get_size(self):
        return self.size
    
    def get_head(self):
        return self.head
    
    def get_tail(self):
        return self.tail