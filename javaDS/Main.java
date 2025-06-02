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

        System.out.println(BST.getHeight());
    }
}
