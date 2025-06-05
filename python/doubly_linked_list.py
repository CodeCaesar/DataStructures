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
    
    def append(self, value):
        """
        Appends Node of given value; <i>i.e. inserts Node of given value at the end.</i>

        Running Time: O(1) + O(1) + O(1) + O(1) + O(1) + O(1) + O(1) + O(1) + O(1) = O(9) = <b>O(1)</b>
        """
        new_node = _Node(value)

        if self.head == None:
            self.head = new_node
            self.tail = self.head
        else:
            self.tail.next_node = new_node
            new_node.prev_node = self.tail
            self.tail = self.tail.next_node
        
        self.size += 1