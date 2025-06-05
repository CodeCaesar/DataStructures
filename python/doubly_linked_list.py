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
    
    def is_empty(self):
        """
        Checks if Linked List is empty.

        Running Time: <b>O(1)</b>
        """
        return self.size == 0
    
    def get_size(self):
        """
        Returns current size of Linked List.
        
        Running Time: <b>O(1)</b>
        """
        return self.size
    
    def get_head(self):
        """
        Returns head Node's value of Linked List.
        
        Running Time: <b>O(1)</b>
        """
        return self.head.data
    
    def get_tail(self):
        """
        Returns tail Node's value of Linked List.

        Running Time: <b>O(1)</b>
        """
        return self.tail.data