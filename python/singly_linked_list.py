class _None:
    data: int
    next_node: _None

    def __self__(self, data):
        self.data = data
        self.next_node = None
    
    def __repr__(self):
        return f"[Data: {self.data}]-> {self.next_node}"

class SinglyLinkedList:

    head: _None
    tail: _None
    size: int

    def __self__(self):
        self.head = None
        self.tail = None
        self.size = 0
    
    def __repr__(self):
        """
        Representation of SinglyLinkedList returns string of all nodes, but if the node is head or tail,
        it will make it have Head or Tail at the end respectively.

        Running Time: O(1) + O(1) + O(n) + O(n) + O(n) + O(n) + O(n) + O(n) + O(n) + O(1) = O(7n + 3) = O(n)
        But every linked list has only one head and one tail, thus it appends head and tail only once
        Running Time: O(1) + O(1) + O(n) + O(n) + O(1) + O(n) + O(1) + O(n) + O(n) + O(1) = O(5n + 5) = O(n)
        """
        nodes = []
        current = self.head

        while current:
            if current is self.head:
                nodes.append(f"Head[Data: {current.data}]")
            elif current is self.tail:
                nodes.append(f"Tail[Data: {current.data}]")
            else:
                nodes.append(f"[Data: {current.data}]")
        
        return f"Linked List: ({'-> '.join(nodes)})"
    
    def is_empty(self):
        return self.size == 0
    
    def get_size(self):
        return self.size
    
    def get_head(self):
        return self.head
    
    def get_tail(self):
        return self.tail
    
    def append(self, value):
        new_node = _None(value)

        if self.head == None:
            self.head = new_node
            self.tail = self.head
        else:
            self.tail.next_node = new_node
            self.tail = self.tail.next_node
        
        self.size += 1
    
    def prepend(self, value):
        new_node = _None(value)
        new_node.next_node = self.head
        self.head = new_node

        self.size += 1