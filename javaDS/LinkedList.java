package javaDS;

public abstract class LinkedList {

    protected class Node {
        protected int data;
        protected Node nextNode = null;

        protected Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "[" + this.data + "]-> " + this.nextNode.toString();
        }
    }

    protected int size;
    protected Node head;
    protected Node tail;

    protected LinkedList() {}

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
