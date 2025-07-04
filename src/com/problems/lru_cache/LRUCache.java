package com.problems.lru_cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insertToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            remove(node);
            insertToHead(node);
        } else {
            if (cache.size() == capacity) {
                Node lru = tail.prev;
                remove(lru);
                cache.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            insertToHead(newNode);
            cache.put(key, newNode);
        }
    }

    private void insertToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1)); // return 1
        lRUCache.put(3, 3); // evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2)); // returns -1
        lRUCache.put(4, 4); // evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1)); // return -1
        System.out.println(lRUCache.get(3)); // return 3
        System.out.println(lRUCache.get(4)); // return 4
    }
}
