class _Node:
    data: int

    def __init__(self, data):
        self.data = data
        self.next_node = None
        self.prev_node = None
    
    def __repr__(self):
        return f"<-[Data: {self.data}]-> {self.next_node}"

class DoublyLinkedList:
    head: _Node
    tail: _Node
    size: int

    def __init__(self):
        self.head = None
        self.tail = None
        self.size = 0