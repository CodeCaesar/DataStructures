class LinkedList:

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