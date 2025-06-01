package javaDS;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList LinkedList = new SinglyLinkedList();
        
        LinkedList.append(5);
        LinkedList.append(3);
        LinkedList.append(1);
        LinkedList.append(8);
        LinkedList.append(6);
        LinkedList.append(9);

        System.out.println(LinkedList);
    }
}
