package javaDS.Trees;

public abstract class BTree extends BinarySearchTree {
    protected int minDegree;
    protected int maxDegree;

    protected class Node {
        protected int keysStored;
        protected int[] key = new int[maxDegree - 1];
        protected Node[] children = new Node[maxDegree];
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

    public BTree(int minDegree) {this.minDegree = minDegree; this.maxDegree = minDegree * 2 - 1;}
}
