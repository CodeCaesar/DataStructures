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

    private Object search(int target, Node current) {
        if(current == null) {
            return null;
        } else if(current.key == target) {
            return current.data;
        } else if(target < current.key) {
            return search(target, current.left);
        } else {
            return search(target, current.right);
        }
    }

    public Object search(int target) {
        return search(target, this.root);
    }

    public Object iterativeSearch(int target) {
        Node current = this.root;

        while(current != null && target != current.key) {
            if(target < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return current.data;
    }

    private Node getNode(int key) {
        Node current = this.root;

        while(current != null && key != current.key) {
            if(key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return current;
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

    private Node min(Node current) {
        while(current.left != null) {
            current = current.left;
        }

        return current;
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

    private void transplant(Node removedNode, Node transplantedNode) {
        if(removedNode.parent == null) {
            this.root = transplantedNode;
        } else if(removedNode == removedNode.parent.left) {
            removedNode.parent.left = transplantedNode;
        } else {
            removedNode.parent.right = transplantedNode;
        }

        if(transplantedNode != null) {
            transplantedNode.parent = removedNode.parent;
        }
    }

    public void delete(int key) {
        Node deleteNode = getNode(key);

        if(deleteNode.left == null) {
            transplant(deleteNode, deleteNode.right);
        } else if(deleteNode.right == null) {
            transplant(deleteNode, deleteNode.left);
        } else {
            Node successor = min(deleteNode.right);

            if(successor.parent != deleteNode) {
                transplant(successor, successor.right);
                successor.right = deleteNode.right;
                successor.right.parent = successor;
            }

            transplant(deleteNode, successor);
            successor.left = deleteNode.left;
            successor.left.parent = successor;
        }
    }
}
