package com.problems.linked_list;


public class ReverseLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(20);
        head.next = new Node(40);
        head.next.next = new Node(60);
        head.next.next.next = new Node(80);

        System.out.println("Original Linked list:");
        printList(head);

        head = reverse(head);

        System.out.println("Reversed Linked list:");
        printList(head);
    }

}
