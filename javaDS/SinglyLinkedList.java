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
        return size == 0;
    }

    public int getSize() {
        return size;
    }
}