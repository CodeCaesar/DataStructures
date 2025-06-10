package javaDS.Trees;

public class RedBlackTree extends BinarySearchTree {

    private final Node nil = new Node(0, null, Colours.BLACK);
    private Node root;
    protected int size;

    private class Node<Data> extends BinaryTree.Node {
        private Node parent = nil;
        private Node left = nil;
        private Node right = nil;
        private Colours colour;

        private Node(int key, Data data) {
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

    private Node getNode(int key) {
        Node current = this.root;

        while(current != this.nil && key != current.key) {
            if(key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if(current.key == key) {
            return current;
        } else {
            return this.nil;
        }
    }

    protected void leftRotate(Node newRightChild) {
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

    protected void rightRotate(Node newLeftChild) {
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

    private Node successor(Node current) {
        while(current.left != this.nil) {
            current = current.left;
        }

        return current;
    }

    private void transplant(Node removedNode, Node transplantedNode) {
        if(removedNode.parent == this.nil) {
            this.root = transplantedNode;
        } else if(removedNode == removedNode.parent.left) {
            removedNode.parent.left = transplantedNode;
        } else {
            removedNode.parent.right = transplantedNode;
        }

        if(transplantedNode != this.nil) {
            transplantedNode.parent = removedNode.parent;
        }
    }

    private void fixDoubleBlack(Node current) {}

    @Override
    public void delete(int key) {
        Node deleteNode = getNode(key);

        if(deleteNode == this.nil) {
            return;
        }

        Node successorNode;

        if(deleteNode.left != this.nil && deleteNode.right != this.nil) {
            successorNode = successor(deleteNode.right);
        } else if(deleteNode.left == this.nil && deleteNode.right == this.nil) {
            successorNode = this.nil;
        } else if(deleteNode.left != this.nil) {
            successorNode = deleteNode.left;
        } else {
            successorNode = deleteNode.right;
        }

        Boolean doubleBlack = (deleteNode.colour == Colours.BLACK) && (successorNode.colour == Colours.BLACK);

        if(deleteNode.left == this.nil) {
            transplant(deleteNode, deleteNode.right);

            if(doubleBlack) {
                fixDoubleBlack(successorNode);
            }
        } else if(deleteNode.right == this.nil) {
            transplant(deleteNode, deleteNode.left);

            if(doubleBlack) {
                fixDoubleBlack(successorNode);
            }
        }

        // TO BE CONT.

        //transplant(deleteNode, successorNode);

        this.size -= 1;
    }

    private boolean validRedParent(Node parent) {
        if(parent == this.nil) {
            return true;
        } else if(parent.colour == Colours.BLACK) {
            return validRedParent(parent.left) && validRedParent(parent.right);
        } else if(parent.left.colour == Colours.BLACK && parent.right.colour == Colours.BLACK) {
            return true && validRedParent(parent.left) && validRedParent(parent.right);
        } else {
            return false;
        }
    }

    private int compareBlackDepth(Node current) {
        int isBlack;
        
        if(current.colour == Colours.BLACK) {
            isBlack = 1;
        } else {
            isBlack = 0;
        }

        if(current == this.nil) {
            return 0;
        } else if(current.left == this.nil && current.right == this.nil) {
            return isBlack;
        }
        
        int leftDepth = compareBlackDepth(current.left);

        if(leftDepth == compareBlackDepth(current.right)) {
            return isBlack + leftDepth;
        } else {
            return -1;
        }
    }

    private boolean validBlackDepth(Node current) {
        if(current.left == this.nil && current.right == this.nil) {
            return true;
        } else if(compareBlackDepth(current) == -1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Checks if Red-Black Tree is valid by checking following properties
     * <li>1. Every node is either red or black</li>
     * <li>2. Root is black</li>
     * <li>3. Every leaf node is black</li>
     * <li>4. If node is red then both its children are black</li>
     * <li>5. Every path must have same black depth</li>
     * 
     * Colours.java guarantees 1st property; nil field guarantees 3rd property. Thus this method only has to check 2nd, 4th and 5th property.
     */
    public boolean valid() {
        if(this.root.colour == Colours.RED) {
            return false;
        } else if(!validRedParent(this.root)) {
            return false;
        } else if(!validBlackDepth(this.root)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return this.root.toString();
    }

    /**
     * Any methods below are only for testing purposes
     */

    public void setRoot(Node rootNode) {
        this.root = rootNode;
    }
    
    public void setLeft(Node parent, Node leftNode) {
            parent.left = leftNode;
            leftNode.parent = parent;
        }

    public void setRight(Node parent, Node rightNode) {
        parent.right = rightNode;
        rightNode.parent = parent;
    }

    public static void main(String[] args) {
        RedBlackTree RBT = new RedBlackTree();

        Node rottNode = RBT.new Node(0, "", Colours.RED);
        RBT.setRoot(rottNode);

        System.out.println(RBT.valid());

        rottNode = RBT.new Node(4, "", Colours.BLACK);
        RBT.setRoot(rottNode);
        Node leftNode = RBT.new Node(6, "", Colours.RED);
        Node childNode = RBT.new Node(5, "", Colours.RED);
        RBT.setLeft(RBT.root, leftNode);
        RBT.setRight(leftNode, childNode);

        System.out.println(RBT.valid());

        rottNode = RBT.new Node(4, "", Colours.BLACK);
        RBT.setRoot(rottNode);
        leftNode = RBT.new Node(6, "", Colours.BLACK);
        Node rightNode = RBT.new Node(2, "", Colours.RED);
        RBT.setLeft(RBT.root, leftNode);
        RBT.setRight(RBT.root, rightNode);

        System.out.println(RBT.valid());
    }
}
