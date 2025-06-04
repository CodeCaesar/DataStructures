package javaDS;

import javaDS.Trees.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        /*SinglyLinkedList LinkedList = new SinglyLinkedList();

        LinkedList.append(5);
        LinkedList.append(3);
        LinkedList.append(1);
        LinkedList.append(8);
        LinkedList.append(6);
        LinkedList.append(9);

        System.out.println(LinkedList);

        LinkedList.remove(2);
        LinkedList.remove(1);
        LinkedList.remove(5);
        LinkedList.remove(9);
        LinkedList.remove(8);
        LinkedList.remove(3);
        LinkedList.remove(3);
        LinkedList.remove(6);
        LinkedList.remove(6);

        System.out.println(LinkedList);*/

        BinarySearchTree BST = new BinarySearchTree();

        BST.insert(5, "h341f");
        BST.insert(2,"hello world");
        BST.insert(8, "java");
        BST.insert(12, "1100");
        BST.insert(7, "lucky");
        BST.insert(3, "0011");

        System.out.println("inorder:");
        BST.inorder();
        System.out.println("preorder:");
        BST.preorder();
        System.out.println("postorder:");
        BST.postorder();

        System.out.println("Max: " + BST.max() + ", Min: " + BST.min());

        System.out.println(BST.search(7));
        System.out.println(BST.search(1));

        System.out.println(BST);

        //BST.delete(7);
        BST.delete(5);

        System.out.println("inorder:");
        BST.inorder();
        System.out.println("preorder:");
        BST.preorder();
        System.out.println("postorder:");
        BST.postorder();

        System.out.println("Max: " + BST.max() + ", Min: " + BST.min());

        System.out.println(BST.search(7));
        System.out.println(BST.search(1));

        System.out.println(BST);
    }
}
