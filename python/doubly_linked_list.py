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
    
    def __repr__(self):
        """
        Representation of DoublyLinkedList returns string of all nodes, but if the node is head or tail,
        it will make it have Head or Tail at the end respectively.
        
        Running Time: O(1) + O(1) + O(n) + O(n) + O(n) + O(n) + O(n) + O(n) + O(n) + O(n) + O(n) = O(9n + 2) = <b>O(n)</b><p>
        But every linked list has only one head and one tail, thus it appends head and tail only once.<p>
        Running Time: O(1) + O(1) + O(n) + O(n) + O(1) + O(n) + O(1) + O(n) + O(n) + O(n) + O(n) = O(7n + 4) = <b>O(n)</b>
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
            
            current = current.next_node
        
        return f"Linked List: ({' <=> '.join(nodes)})"
    
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
    
    def prepend(self, value):
        """
        Prepend Node of given value; <i>i.e. inserts Node of given value at the start.</i>

        Running Time: O(1) + O(1) + O(1) + O(1) + O(1) = O(5) = <b>O(1)</b>
        """
        new_node = _Node(value)
        new_node.next_node = self.head
        self.head.prev_node = new_node
        self.head = new_node

        self.size += 1

list = DoublyLinkedList()
list.append(5)
list.append(6)
list.append(2)
list.append(9)
list.append(4)
list.append(3)
list.prepend(7)

print(list)