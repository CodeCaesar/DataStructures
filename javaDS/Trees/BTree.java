package javaDS.Trees;

public abstract class BTree extends BinarySearchTree {
    protected int minDegree;

    protected class Node {
        protected int keysStored;
        protected int[] key = new int[minDegree * 2 - 1];
        protected Node[] children;
        protected boolean leaf;

        protected Node(int[] key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return "";
        }
    }

    public BTree() {}

    public BTree(int minDegree) {this.minDegree = minDegree;}
}
