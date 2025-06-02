package javaDS.Trees;

public abstract class BinaryTree {
    
    protected Node root;
    protected int height;
    
    protected class Node {
        protected int data;
        protected Node parent = null;
        protected Node left = null;
        protected Node right = null;

        protected Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "{" + this.left.toString() + "} <-[" + this.data + "]-> {" + this.right.toString() + "}";
        }
    }

    protected BinaryTree() {}

    public int getHeight() {
        return this.height;
    }

    public int getRoot() {
        return this.root.data;
    }
}
