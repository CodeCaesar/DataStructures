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
     * Running Time: O(1) + O(1) + O(1) + O(1) + O(1) + O(1) + O(1) + O(1) = O(8) = <b>O(1)</b>
     */
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
    
    /**
     * Prepend Node of given value; <i>i.e. inserts Node of given value at the start.</i>
     * <p>
     * Running Time: O(1) + O(1) + O(1) + O(1) = O(4) = <b>O(1)</b>
     */
    public void prepend(int value) {
        Node newNode = new Node(value);
        newNode.nextNode = this.head;
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
     * {@code Element-Found} Case: O(1) + O(1) + O(1) + O(1) + O(6) + O(1) + O(1) + O(1) + O(1) + O(1) + O(1) + O(n) + O(n) + O(1) + O(1) + O(1) + O(n) 
     * = O(3n + 19) = <b>O(n)</b> <p>
     * {@code Element-Not-Found} Case: O(1) + O(1) + O(1) + O(1) + O(6) + O(1) + O(1) + O(1) + O(1) + O(1) + O(1) + O(n) + O(n) + O(n) + O(1) 
     * = O(3n + 17) = <b>O(n)</b><p>
     * Even tho {@code Element-Found} case has time complexity of O(3n + 19) which is larger than {@code Element-Not-Found} case's time complexity of O(3n + 17). 
     * Most of the time removed Node will not be tail, thus in most cases it wouldn't have go through entire Linked List, making {@code Element-Not-Found} case
     * worse overall.
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
     * <p>
     * Running Time: O(1) + O(1) + O(n) + O(n) + O(n) + O(n) + O(n) + O(n) + O(n) + O(n) + O(n) = O(9n + 2) = <b>O(n)<p></b>
     * <i>But every linked list has only one head and one tail, thus it appends head and tail only once.</i><p>
     * Running Time: O(1) + O(1) + O(n) + O(n) + O(1) + O(n) + O(1) + O(n) + O(n) + O(n) + O(n) = O(7n + 4) = <b>O(n)<p></b>
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