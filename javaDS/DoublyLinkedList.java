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
}
