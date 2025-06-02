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

    private void inorder(Node current) {
        if(current != null) {
            inorder(current.left);
            System.out.println(current.data);
            inorder(current.right);
        }
    }
    
    public void inorder() {
        inorder(this.root);
    }

    /**
     * TEMPORARY METHOD
     * <p>
     * Only For Used Testing
     */
    public void makeRoot(int key) {
        this.root = new Node(key);
    }

    /**
     * TEMPORARY METHOD
     * <p>
     * Only For Used Testing
     */
    public void makeLeft(int key) {
        this.root.left = new Node(key);
    }
}
