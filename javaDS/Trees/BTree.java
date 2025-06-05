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
            this.leaf = true;
        }

        protected Node() {
            this.leaf = true;
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

    private void splitChild(Node parent, int index) {
        Node extraChild = new Node();
        Node child = parent.children[index];
        extraChild.leaf = child.leaf;
        extraChild.keysStored = minDegree - 1;

        for(int keyIndex = 0; keyIndex < minDegree - 1; keyIndex++) {
            extraChild.keys[keyIndex] = child.keys[keyIndex + minDegree];
        }

        if(!child.leaf) {
            for(int childIndex = 0; childIndex < minDegree; childIndex++) {
                extraChild.children[childIndex] = child.children[childIndex + minDegree];
            }
        }

        child.keysStored = minDegree - 1;

        for(int updateChildren = parent.keysStored; updateChildren > index; updateChildren--) {
            parent.children[updateChildren + 1] = parent.children[updateChildren];
        }

        parent.children[index + 1] = extraChild;

        for(int updateKeys = parent.keysStored - 1; updateKeys > index - 1; updateKeys--) {
            parent.keys[updateKeys] = parent.keys[updateKeys + minDegree];
        }

        parent.keys[index] = child.keys[minDegree - 1];
        parent.keysStored += 1;
    }

    private void insertNonfull(Node target, int key) {
        int index = target.keysStored - 1;

        if(target.leaf) {
            while(index >= 0 && key < target.keys[index]) {
                target.keys[index + 1] = target.keys[index];
                index -= 1;
            }

            target.keys[index + 1] = key;
            target.keysStored += 1;
        } else {
            while(index >= 0 && key < target.keys[index]) {
                index -= 1;
            }

            index += 1;
            
            if(target.children[index].keysStored == maxDegree) {
                splitChild(target, index);

                if(key > target.keys[index]) {
                    index += 1;
                }
            }

            insertNonfull(target.children[index], key);
        }
    }
}
