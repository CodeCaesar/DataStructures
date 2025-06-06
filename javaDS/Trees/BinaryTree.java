package javaDS.Trees;

public abstract class BinaryTree {
    
    protected Node root;
    protected int size;
    
    protected class Node<Data> {
        protected int key;
        protected Data data;
        protected Node parent = null;
        protected Node left = null;
        protected Node right = null;

        protected Node(int key, Data data) {
            this.key = key;
            this.data = data;
        }

        @Override
        public String toString() {
            String leftString;
            String rightString;

            if(this.left == null) {
                leftString = "Null";
            } else {
                leftString = this.left.toString();
            }

            if(this.right == null) {
                rightString = "Null";
            } else {
                rightString = this.right.toString();
            }

            return "{" + leftString + "} <-[" + this.key + "]-> {" + rightString + "}";
        }
    }

    protected BinaryTree() {}

    public int getSize() {
        return this.size;
    }

    public int getRoot() {
        return this.root.key;
    }

    private void inorder(Node current) {
        if(current != null) {
            inorder(current.left);
            System.out.println(current.key);
            inorder(current.right);
        }
    }
    
    public void inorder() {
        inorder(this.root);
    }

    private void preorder(Node current) {
        if(current != null) {
            System.out.println(current.key);
            preorder(current.left);
            preorder(current.right);
        }
    }
    
    public void preorder() {
        preorder(this.root);
    }

    private void postorder(Node current) {
        if(current != null) {
            postorder(current.left);
            postorder(current.right);
            System.out.println(current.key);
        }
    }
    
    public void postorder() {
        postorder(this.root);
    }

    private int maxHeight(int height1, int height2) {
        if(height1 >= height2) {
            return height1;
        } else {
            return height2;
        }
    }

    private int height(Node current) {
        if(current == null) {
            return 0;
        } else if(current.left == null && current.right == null) {
            return 0;
        }

        return maxHeight(height(current.left), height(current.right)) + 1;
    }

    public int height() {
        return height(this.root);
    }

    public int size() {
        return this.size;
    }
}
