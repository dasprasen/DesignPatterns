package com.problems;

import java.util.HashMap;
import java.util.Map;

/* Create a doubly linked list
 * if size is more than the capacity, then oldest one will be deleted
 * get operation should be O(1), get should happen by providing index, get(index)
*/
public class DoublyLinkedList {

    class Node {
        private String value;
        private Node prev;
        private Node next;
        private int index;

        public Node(String value) {
            this.value = value;
            this.index = 0;
            this.next = null;
            this.prev = null;
        }
    }

    private int capacity;
    private Node head;
    private Node tail;
    private int size;
    private Map<Integer, Node> indexMap;
    private int baseIndex;

    public DoublyLinkedList(int capacity) {
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.indexMap = new HashMap<>();
        this.baseIndex = 0;
    }

    public void add(String value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        indexMap.put(baseIndex + size, newNode);
        size++;
        if (size > capacity) {
            indexMap.remove(baseIndex);
            head = head.next;
            if(head != null) {
                head.prev = null;
            }
            baseIndex++;
            size--;
        }
    }

    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node node = indexMap.get(baseIndex + index);
        if (node == null) {
            throw new IndexOutOfBoundsException();
        }
        return node.value;
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList(3);
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println(list.get(0)); // A
        System.out.println(list.get(2)); // C

        list.add("D"); // Should remove A
        System.out.println(list.get(0)); // B
        System.out.println(list.get(2)); // D
    }
}
