package javaDS.Trees;

public class RedBlackTree extends BinarySearchTree {

    protected final Node nil = new Node(0, null, Colours.BLACK);
    protected Node root;
    protected int size;

    protected class Node<Data> extends BinaryTree.Node {
        protected Node parent = nil;
        protected Node left = nil;
        protected Node right = nil;
        private Colours colour;

        protected Node(int key, Data data) {
            super(key, data);
            this.colour = Colours.RED;
        }

        private Node(int key, Data data, Colours colour) {
            super(key, data);
            this.colour = colour;
        }

        @Override
        public String toString() {
            String leftString;
            String rightString;

            if(this.left == nil) {
                leftString = "Nil";
            } else {
                leftString = this.left.toString();
            }

            if(this.right == nil) {
                rightString = "Nil";
            } else {
                rightString = this.right.toString();
            }

            return "{" + leftString + "} <-[" + this.key + ":" + this.colour + "]-> {" + rightString + "}";
        }
    }

    public RedBlackTree() {this.root = this.nil;}

    private void leftRotate(Node newRightChild) {
        Node newParent = newRightChild.right;
        newRightChild.right = newParent.left;

        if(newParent.left != this.nil) {
            newParent.left.parent = newRightChild;
        }

        newParent.parent = newRightChild.parent;

        if(newRightChild.parent == this.nil) {
            this.root = newParent;
        } else if(newRightChild == newRightChild.parent.left) {
            newRightChild.parent.left = newParent;
        } else {
            newRightChild.parent.right = newParent;
        }

        newParent.left = newRightChild;
        newRightChild.parent = newParent;
    }

    private void rightRotate(Node newLeftChild) {
        Node newParent = newLeftChild.left;
        newLeftChild.left = newParent.right;

        if(newParent.right != this.nil) {
            newParent.right.parent = newLeftChild;
        }

        newParent.parent = newLeftChild.parent;

        if(newLeftChild.parent == this.nil) {
            this.root = newParent;
        } else if(newLeftChild == newLeftChild.parent.right) {
            newLeftChild.parent.right = newParent;
        } else {
            newLeftChild.parent.left = newParent;
        }

        newParent.right = newLeftChild;
        newLeftChild.parent = newParent;
    }

    private void fixupCaseA(Node newNode) {
        Node uncle = newNode.parent.parent.right;

        if(uncle.colour == Colours.RED) { // CASE 1
            newNode.parent.colour = Colours.BLACK;
            uncle.colour = Colours.BLACK;
            newNode.parent.parent.colour = Colours.RED;
            newNode = newNode.parent.parent;
        } else {
            if(newNode == newNode.parent.right) { // CASE 2
                newNode = newNode.parent;
                leftRotate(newNode);
            }

            // CASE 2 & 3
            newNode.parent.colour = Colours.BLACK;
            newNode.parent.parent.colour = Colours.RED;
            rightRotate(newNode.parent.parent);
        }
    }

    private void fixupCaseB(Node newNode) {
        Node uncle = newNode.parent.parent.left;

        if(uncle.colour == Colours.RED) { // CASE 1
            newNode.parent.colour = Colours.BLACK;
            uncle.colour = Colours.BLACK;
            newNode.parent.parent.colour = Colours.RED;
            newNode = newNode.parent.parent;
        } else {
            if(newNode == newNode.parent.left) { // CASE 2
                newNode = newNode.parent;
                rightRotate(newNode);
            }

            // CASE 2 & 3
            newNode.parent.colour = Colours.BLACK;
            newNode.parent.parent.colour = Colours.RED;
            leftRotate(newNode.parent.parent);
        }
    }

    private void fixup(Node newNode) {
        while(newNode.parent.colour == Colours.RED) {
            if(newNode.parent == newNode.parent.parent.left) {
                fixupCaseA(newNode);
            } else {
                fixupCaseB(newNode);
            }
        }

        this.root.colour = Colours.BLACK;
    }

    private void insert(Node newNode) {
        Node parent = this.nil;
        Node child = this.root;

        while(child != this.nil) {
            parent = child;

            if(newNode.key < child.key) {
                child = child.left;
            } else {
                child = child.right;
            }
        }

        newNode.parent = parent;

        if(parent == this.nil) {
            this.root = newNode;
        } else if(newNode.key < parent.key) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        fixup(newNode);
    }

    @Override
    public void insert(int key, Object data) {
        Node newNode = new Node(key, data);

        insert(newNode);
        this.size += 1;
    }

    @Override
    public String toString() {
        return this.root.toString();
    }
}
