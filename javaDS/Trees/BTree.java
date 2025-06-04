package javaDS.Trees;

public class BTree extends BinaryTree {
    protected Node root;
    protected int size;
    protected int minDegree;
    protected int maxDegree;

    protected class Node {
        protected int keysStored;
        protected int[] keys = new int[maxDegree - 1];
        protected Node[] children = new Node[maxDegree];
        protected boolean leaf;

        protected Node(int[] keys) {
            this.keys = keys;
        }

        @Override
        public String toString() {
            return "";
        }
    }

    public BTree() {}

    public BTree(int minDegree) {this.minDegree = minDegree; this.maxDegree = minDegree * 2 - 1;}

    private boolean has(Node current, int targetKey) {
        int index = 0;

        while(index < current.keysStored && targetKey > current.keys[index]) {
            index += 1;
        }

        if(index < current.keysStored && targetKey == current.keys[index]) {
            return true;
        } else if(current.leaf) {
            return false;
        } else {
            return has(current.children[index], targetKey);
        }
    }

    public boolean has(int targetKey) {
        return has(this.root, targetKey);
    }
}
