package javaDS.Trees;

public class RedBlackTree extends BinarySearchTree {

    protected final Node nil = null;
    protected Node root;
    protected int size;

    protected class Node<Data> extends BinaryTree.Node {
        protected int key;
        protected Data data;
        protected Node parent = nil;
        protected Node left = nil;
        protected Node right = nil;
        private Colours colour;

        protected Node(int key, Data data) {
            super(key, data);
            this.colour = Colours.RED;
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

            return "{" + leftString + "} <-[" + this.key + "]-> {" + rightString + "}";
        }
    }

    public RedBlackTree() {}

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

    private void rightRotate() {}

    @Override
    public String toString() {
        return this.root.toString();
    }
}
