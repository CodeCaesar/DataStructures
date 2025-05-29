class _None:
    data: int
    next_node: _None

    def __self__(self, data):
        self.data = data

class SinglyLinkedList:

    head: _None
    tail: _None
    size: int

    def __self__(self):
        self.head = None
        self.tail = None
        self.size = 0