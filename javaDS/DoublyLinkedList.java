package javaDS;

public class DoublyLinkedList {
    
    private class Node {
        private int data;
        private Node nextNode = null;
        private Node prevNode = null;

        private Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "<-[" + this.data + "]-> " + this.nextNode.toString();
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
    }

    /**
     * Checks if Linked List is empty.
     * <p>
     * Running Time: <b>O(1)</b>
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Returns current size of Linked List.
     * <p>
     * Running Time: <b>O(1)</b>
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Returns head Node's value of Linked List.
     * <p>
     * Running Time: <b>O(1)</b>
     */
    public int getHead() {
        return this.head.data;
    }

    /**
     * Returns tail Node's value of Linked List.
     * <p>
     * Running Time: <b>O(1)</b>
     */
    public int getTail() {
        return this.tail.data;
    }

    /**
     * Appends Node of given value; <i>i.e. inserts Node of given value at the end.</i>
     * <p>
     * Running Time: O(1) + O(1) + O(1) + O(1) + O(1) + O(1) + O(1) + O(1) + O(1) = O(9) = <b>O(1)</b>
     */
    public void append(int value) {
        Node newNode = new Node(value);

        if(this.head == null) {
            this.head = newNode;
            this.tail = this.head;
        } else {
            this.tail.nextNode = newNode;
            newNode.prevNode = this.tail;
            this.tail = this.tail.nextNode;
        }
        
        this.size += 1;
    }
    
    /**
     * Prepend Node of given value; <i>i.e. inserts Node of given value at the start.</i>
     * <p>
     * Running Time: O(1) + O(1) + O(1) + O(1) + O(1) = O(5) = <b>O(1)</b>
     */
    public void prepend(int value) {
        Node newNode = new Node(value);
        newNode.nextNode = this.head;
        this.head.prevNode = newNode;
        this.head = newNode;

        this.size += 1;
    }

    /**
     * Checks if Linked List's head has given value. If yes then make head and tail null and reduce size by one.
     * Else print error that Noce of given value wasn't found.
     * <p>
     * Running Time: O(1) + O(1) + O(1) + O(1) + O(1) + O(1) = O(6) = <b>O(1)</b>
     */
    private void removeSolo(int value) {
        if(this.head.data == value) {
            this.head = null;
            this.tail = null;
            this.size -= 1;
        } else {
            System.err.println("Node with value: '" + value + "' not found");
        }
    }

    /**
     * Removes first Node of given value. If size is zero print error message, if size is one then call removeSolo().
     * If Node with given value is found then make current Node point to its grandchild.
     * 
     * <h3>Running Time:</h3>
     * Best Case: O(1) + O(1) + O(1) = O(3) = <b>O(1)</b> <p>
     * {@code Element-Found} Case: O(1) + O(1) + O(1) + O(1) + O(6) + O(1) + O(1) + O(1) + O(1) + O(1) + O(1) + O(1) + O(n) + O(n) + O(1) + O(1) + O(1) + O(1) + O(1) + O(n) 
     * = O(3n + 22) = <b>O(n)</b> <p>
     * {@code Element-Not-Found} Case: O(1) + O(1) + O(1) + O(1) + O(6) + O(1) + O(1) + O(1) + O(n) + O(n) + O(n) + O(1) 
     * = O(3n + 14) = <b>O(n)</b><p>
     */
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
            this.head.prevNode = null;
            this.size -= 1;
            return;
        }

        while(current.nextNode != null) {
            if(current.nextNode.data == value) {
                current.nextNode = current.nextNode.nextNode;

                if(current.nextNode != null) {
                    current.nextNode.prevNode = current;
                }

                this.size -= 1;
                return;
            }

            current = current.nextNode;
        }
        
        System.err.println("Node with value: '" + value + "' not found");
    }
}
