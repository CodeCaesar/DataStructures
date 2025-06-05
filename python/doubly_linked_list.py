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
    
    def __remove_solo(self, value):
        """
        Checks if Linked List's head has given value. If yes then make head and tail null and reduce size by one.
        Else print error that Noce of given value wasn't found.

        Running Time: O(1) + O(1) + O(1) + O(1) + O(1) + O(1) = O(6) = <b>O(1)</b>
        """
        if self.head.data == value:
            self.head = None
            self.tail = None
            self.size -= 1
        else:
            print(f'Node with value: "{value}" not found')

    def remove(self, value):
        """
        Removes first Node of given value. If size is zero print error message, if size is one then call __remove_solo().
        If Node with given value is found then make current Node point to its grandchild.

        <h3>Running Time:</h3>
        Best Case: O(1) + O(1) + O(1) = O(3) = <b>O(1)</b> <p>
        Element-Found Case: O(1) + O(1) + O(1) + O(1) + O(6) + O(1) + O(1) + O(1) + O(1) + O(1) + O(1) + O(1) + O(n) + O(n) + O(1) + O(1) + O(1) + O(1) + O(1) + O(n) 
        = O(3n + 22) = <b>O(n)</b> <p>
        Element-Not-Found Case: O(1) + O(1) + O(1) + O(1) + O(6) + O(1) + O(1) + O(1) + O(n) + O(n) + O(n) + O(1) 
        = O(3n + 14) = <b>O(n)</b><p>
        """
        if self.size == 0:
            print("Linked List is empty")
            return

        if self.size == 1:
            self.__remove_solo(value)
            return
        
        current = self.head

        if current.data == value:
            self.head = self.head.next_node
            self.head.prev_node = None
            self.size -= 1
            return

        while current.next_node:
            if current.next_node.data == value:
                current.next_node = current.next_node.next_node

                if current.next_node:
                    current.next_node.prev_node = current
                
                self.size -= 1
                return

            current = current.next_node
        
        print(f'Node with value: "{value}" not found')

list = DoublyLinkedList()
list.append(5)
list.append(6)
list.append(2)
list.append(9)
list.append(4)
list.append(3)
list.prepend(7)
list.remove(7)
list.remove(4)
list.remove(3)
list.remove(942)

print(list)