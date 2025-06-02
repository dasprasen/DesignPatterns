package com.problems.linked_list;

public class MiddleLinkedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(20);
        head.next = new ListNode(40);
        head.next.next = new ListNode(60);
        head.next.next.next = new ListNode(80);

        System.out.println("Original Linked list:");
        printList(head);

        System.out.println("Middle of Linked list:");
        printList(middleNode(head));
    }
}
