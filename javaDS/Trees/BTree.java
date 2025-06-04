package javaDS.Trees;

public abstract class BTree extends BinarySearchTree {
    protected int minDegree;

    protected class Node<Data> {
        protected int keysStored;
        protected int[] key = new int[minDegree * 2 - 1];
        protected Data data;
        protected Node[] children;

        protected Node(int[] key, Data data) {
            this.key = key;
            this.data = data;
        }

        @Override
        public String toString() {
            return "";
        }
    }

    public BTree() {}

    public BTree(int minDegree) {this.minDegree = minDegree;}
}
