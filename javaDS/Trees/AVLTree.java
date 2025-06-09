package javaDS.Trees;

public class AVLTree extends RedBlackTree {

    private final Node nil = new Node(0, null);
    private Node root;
    private int size;

    private class Node<Data> extends BinaryTree.Node {
        private Node parent = nil;
        private Node left = nil;
        private Node right = nil;
        private int height = 0;

        private Node(int key, Data data) {
            super(key, data);
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

            return "{" + leftString + "} <-[" + this.key + ":" + this.height + "]-> {" + rightString + "}";
        }
    }

    public AVLTree() {}

    // TO BE CONT.
}
