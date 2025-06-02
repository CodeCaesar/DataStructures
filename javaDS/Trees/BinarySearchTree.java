package javaDS.Trees;

public class BinarySearchTree extends BinaryTree {
    public BinarySearchTree() {}

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
