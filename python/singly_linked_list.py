class _Node:
    data: int

    def __init__(self, data):
        self.data = data
        self.next_node = None
    
    def __repr__(self):
        return f"[Data: {self.data}]-> {self.next_node}"

class SinglyLinkedList:

    head: _Node
    tail: _Node
    size: int

    def __init__(self):
        self.head = None
        self.tail = None
        self.size = 0
    
    def __repr__(self):
        """
        Representation of SinglyLinkedList returns string of all nodes, but if the node is head or tail,
        it will make it have Head or Tail at the end respectively.

        Running Time: O(1) + O(1) + O(n) + O(n) + O(n) + O(n) + O(n) + O(n) + O(n) + O(n) + O(1) = O(8n + 3) = O(n)
        But every linked list has only one head and one tail, thus it appends head and tail only once.
        Running Time: O(1) + O(1) + O(n) + O(n) + O(1) + O(n) + O(1) + O(n) + O(n) + O(n) + O(1) = O(6n + 5) = O(n)
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
        new_node = _Node(value)

        if self.head == None:
            self.head = new_node
            self.tail = self.head
        else:
            self.tail.next_node = new_node
            self.tail = self.tail.next_node
        
        self.size += 1
    
    def prepend(self, value):
        new_node = _Node(value)
        new_node.next_node = self.head
        self.head = new_node

        self.size += 1
    
    def __remove_solo(self, value):
        if self.head.data == value:
            self.head = None
            self.tail = None
            self.size -= 1
        else:
            print(f'Node with value: "{value}" not found')

    def remove(self, value):
        if self.size == 0:
            print("Linked List is empty")
            return

        if self.size == 1:
            self.__remove_solo(value)
            return
        
        current = self.head

        if current.data == value:
            self.head = self.head.next_node
            self.size -= 1
            return

        while current.next_node:
            if current.next_node.data == value:
                current.next_node = current.next_node.next_node
                self.size -= 1
                return

            current = current.next_node
        
        print(f'Node with value: "{value}" not found')


list = SinglyLinkedList()
list.append(5)
list.append(6)
list.append(2)
list.append(9)
list.append(4)
list.append(3)
list.remove(5)
list.remove(4)
list.remove(942)

print(list)