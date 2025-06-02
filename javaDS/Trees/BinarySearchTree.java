package javaDS.Trees;

public class BinarySearchTree extends BinaryTree {
    public BinarySearchTree() {}

    private boolean has(int key, Node current) {
        if(current == null) {
            return false;
        } else if(current.data == key) {
            return true;
        } else if(key < current.data) {
            return has(key, current.left);
        } else {
            return has(key, current.right);
        }
    }

    public boolean has(int key) {
        return has(key, this.root);
    }

    public int min() {
        Node current = this.root;

        while(current != null) {
            current = current.left;
        }

        return current.data;
    }

    public int max() {
        Node current = this.root;

        while(current != null) {
            current = current.right;
        }

        return current.data;
    }
}
