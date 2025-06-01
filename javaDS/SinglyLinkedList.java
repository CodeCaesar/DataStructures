package javaDS;

public class SinglyLinkedList {

    private class Node {
        private int data;
        private Node nextNode = null;

        private Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "[" + this.data + "]-> " + this.nextNode.toString();
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList() {
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int getSize() {
        return this.size;
    }

    public int getHead() {
        return this.head.data;
    }

    public int getTail() {
        return this.tail.data;
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if(this.head == null) {
            this.head = newNode;
            this.tail = this.head;
        } else {
            this.tail.nextNode = newNode;
            this.tail = this.tail.nextNode;
        }
        
        this.size += 1;
    }
    
    public void prepend(int value) {
        Node newNode = new Node(value);
        newNode.nextNode = this.head;
        this.head = newNode;

        this.size += 1;
    }

    private void removeSolo(int value) {
        if(this.head.data == value) {
            this.head = null;
            this.tail = null;
            this.size -= 1;
        } else {
            System.err.println("Node with value: '" + value + "' not found");
        }
    }

    public void remove(int value) {
        if(this.size == 0) {
            System.err.println("Linked List is empty");
            return;
        }

        if(this.size == 1) {
            removeSolo(value);
            return;
        }
        
        Node current = this.head;

        if(current.data == value) {
            this.head = this.head.nextNode;
            this.size -= 1;
            return;
        }

        while(current.nextNode != null) {
            if(current.nextNode.data == value) {
                current.nextNode = current.nextNode.nextNode;
                this.size -= 1;
                return;
            }

            current = current.nextNode;
        }
        
        System.err.println("Node with value: '" + value + "' not found");
    }

    /**
     * String representation of SinglyLinkedList returns string of all nodes, but if the node is head or tail,
     * it will make it have Head or Tail at the end respectively.
     * 
     * @implNote
     * Running Time: O(1) + O(1) + O(n) + O(n) + O(n) + O(n) + O(n) + O(n) + O(n) + O(n) + O(n) = O(8n + 3) = O(n)
     * But every linked list has only one head and one tail, thus it appends head and tail only once.
     * Running Time: O(1) + O(1) + O(n) + O(n) + O(1) + O(n) + O(1) + O(n) + O(n) + O(n) + O(n) = O(6n + 5) = O(n)
     */
    @Override
    public String toString() {
        Node current = this.head;
        String[] nodes = new String[this.size];

        for(int index = 0; index < this.size; index++) {
            if(current == this.head) {
                nodes[0] = "Head[Data: " + current.data + "]";
            } else if(current == this.tail) {
                nodes[index] = "Tail[Data: " + current.data + "]";
            }
            else {
                nodes[index] = "[Data: " + current.data + "]";
            }

            current = current.nextNode;
        }

        return "Linked List: (" + String.join("-> ", nodes) + ")";
    }
}