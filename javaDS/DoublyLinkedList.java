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
}
