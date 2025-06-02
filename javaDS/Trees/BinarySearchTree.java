package javaDS.Trees;

public class BinarySearchTree extends BinaryTree {
    public BinarySearchTree() {}

    private boolean has(int key, Node current) {
        if(current == null) {
            return false;
        } else if(current.key == key) {
            return true;
        } else if(key < current.key) {
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

        if(current == null) {
            return 0;
        }

        while(current.left != null) {
            current = current.left;
        }

        return current.key;
    }

    public int max() {
        Node current = this.root;

        if(current == null) {
            return 0;
        }

        while(current.right != null) {
            current = current.right;
        }

        return current.key;
    }

    private void insert(Node newNode) {
        Node parent = null;
        Node child = this.root;

        while(child != null) {
            parent = child;

            if(newNode.key < child.key) {
                child = child.left;
            } else {
                child = child.right;
            }
        }

        newNode.parent = parent;

        if(parent == null) {
            this.root = newNode;
        } else if(newNode.key < parent.key) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }

    public void insert(int key, Object data) {
        Node newNode = new Node(key, data);

        insert(newNode);
    }
}
