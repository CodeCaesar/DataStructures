package javaDS;

import javaDS.Trees.BTree;
import javaDS.Trees.BinarySearchTree;
import javaDS.Trees.RedBlackTree;

public class Main {
    public static void main(String[] args) {
        //SinglyLinkedList LinkedList = new SinglyLinkedList();
        DoublyLinkedList LinkedList = new DoublyLinkedList();

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

        System.out.println(LinkedList);

        /*RedBlackTree BST = new RedBlackTree();

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
        System.out.println(BST.valid());*/

        //BST.delete(7);
        /*BST.delete(5);

        System.out.println("inorder:");
        BST.inorder();
        System.out.println("preorder:");
        BST.preorder();
        System.out.println("postorder:");
        BST.postorder();

        System.out.println("Max: " + BST.max() + ", Min: " + BST.min());

        System.out.println(BST.search(7));
        System.out.println(BST.search(1));

        System.out.println(BST);*/

        //System.out.println(BST.height());

        /*BTree BT = new BTree(2);

        BT.insert(5);
        BT.insert(7);
        BT.insert(3);
        BT.insert(12);
        BT.insert(24);
        BT.insert(6);
        BT.insert(2);
        BT.insert(1);
        BT.insert(9);
        BT.insert(11);
        BT.insert(8);
        BT.insert(4);
        BT.insert(10);
        BT.insert(23);
        BT.insert(21);
        BT.insert(15);
        BT.insert(16);
        BT.insert(17);

        System.out.println(BT);

        System.out.println("inorder:");
        BT.inorder();
        System.out.println("preorder:");
        BT.preorder();
        System.out.println("postorder:");
        BT.postorder();*/
    }
}
