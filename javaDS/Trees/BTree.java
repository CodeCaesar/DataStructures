package javaDS.Trees;

public class BTree extends BinaryTree {

    protected int minDegree;
    protected int maxDegree;
    protected Node root;
    protected int size;
    protected int height;

    protected class Node {
        protected int keysStored;
        protected int[] keys = new int[maxDegree];
        protected Node[] children = new Node[maxDegree + 1];
        protected boolean leaf;

        protected Node(int[] keys) {
            this.keys = keys;
            this.leaf = true;
        }

        protected Node() {
            this.leaf = true;
        }

        private String[] stringKeys(int[] keys) {
            String[] keyArray = new String[maxDegree - 1];

            for(int index = 0; index < maxDegree - 1; index++) {
                keyArray[index] = "" + this.keys[index];
            }

            return keyArray;
        }

        @Override
        public String toString() {
            return "[Keys: " + String.join(",", stringKeys(keys)) + "]-> " + children.toString();
        }
    }

    public BTree() {this.maxDegree = 2 * this.minDegree - 1;}

    public BTree(int minDegree) {
        this.minDegree = minDegree;
        this.maxDegree = 2 * this.minDegree - 1;
        this.root = new Node();
    }

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

    private void fixNode(Node brokenNode) {
        for(int index = this.maxDegree - 1; index >= brokenNode.keysStored; index--) {
            brokenNode.keys[index] = 0;
        }

        for(int index = this.maxDegree; index > brokenNode.keysStored; index--) {
            brokenNode.children[index] = null;
        }
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
            parent.keys[updateKeys + 1] = parent.keys[updateKeys];
        }

        parent.keys[index] = child.keys[minDegree - 1];
        parent.keysStored += 1;
        this.height += 1;
        fixNode(child);
    }

    private void insertNonfull(Node current, int key) {
        int index = current.keysStored - 1;

        if(current.leaf) {
            while(index >= 0 && key < current.keys[index]) {
                current.keys[index + 1] = current.keys[index];
                index -= 1;
            }

            current.keys[index + 1] = key;
            current.keysStored += 1;
        } else {
            while(index >= 0 && key < current.keys[index]) {
                index -= 1;
            }

            index += 1;
            
            if(current.children[index].keysStored == maxDegree) {
                splitChild(current, index);

                if(key > current.keys[index]) {
                    index += 1;
                }
            }

            insertNonfull(current.children[index], key);
        }
    }

    public void insert(int key) {
        Node rut = this.root;
        this.size += 1;

        if(rut.keysStored == maxDegree) {
            Node newNode = new Node();
            this.root = newNode;
            newNode.leaf = false;
            newNode.keysStored = 0;
            newNode.children[0] = rut;

            splitChild(newNode, 0);
            insertNonfull(newNode, key);
        } else {
            insertNonfull(this.root, key);
        }
    }

    private String[] stringKeys(Node node, int[] keys) {
        String[] keyArray = new String[node.keysStored];

        for(int index = 0; index < node.keysStored; index++) {
            keyArray[index] = "" + node.keys[index];
        }

        return keyArray;
    }

    private void inorder(Node current) {
        if(current != null) {
            int totalKeysChildren = 2 * current.keysStored + 1;

            for(int index = 0; index < totalKeysChildren; index++) {
                if(index % 2 == 0) {
                    inorder(current.children[index / 2]);
                } else {
                    System.out.println(current.keys[index / 2]);
                }
            }
        }
    }

    @Override
    public void inorder() {
        inorder(this.root);
    }

    private void preorder(Node current) {
        if(current != null) {
            System.out.println(String.join(",", stringKeys(current, current.keys)));

            for(int index = 0; index < current.keysStored + 1; index++) {
                preorder(current.children[index]);
            }
        }
    }

    @Override
    public void preorder() {
        preorder(this.root);
    }

    private void postorder(Node current) {
        if(current != null) {
            for(int index = 0; index < current.keysStored + 1; index++) {
                postorder(current.children[index]);
            }

            System.out.println(String.join(",", stringKeys(current, current.keys)));
        }
    }

    @Override
    public void postorder() {
        postorder(this.root);
    }

    @Override
    public int height() {
        return this.height;
    }

    @Override
    public String toString() {
        return this.root.toString();
    }
}
