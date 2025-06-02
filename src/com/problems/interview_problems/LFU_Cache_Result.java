package com.problems.interview_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/*
Microsoft 2nd round
We need to implement an LFU Cache that:
Has a fixed capacity
Supports GET(key) and PUT(key, value) operations
When cache is full, removes the least frequently used item
If there's a tie in frequency, removes the least recently used among them
 */
public class LFU_Cache_Result {

    public static void main(String[] args) {
        // Test case 1
        System.out.println("=== Test Case 1 ===");
        int cacheSize1 = 2;
        List<String> queries1 = Arrays.asList(
                "PUT 1 1",
                "PUT 2 2",
                "GET 1",
                "PUT 3 3",
                "GET 2",
                "GET 3",
                "PUT 4 4",
                "GET 1",
                "GET 3",
                "GET 4"
        );

        List<Integer> result1 = implementLFU(cacheSize1, queries1);
        System.out.println("Results: " + result1); // Expected: [1, -1, 3, -1, 3, 4]

        // Test case 2
        System.out.println("\n=== Test Case 2 ===");
        int cacheSize2 = 1;
        List<String> queries2 = Arrays.asList(
                "PUT 2 1",
                "GET 2",
                "PUT 3 2",
                "GET 2",
                "GET 3"
        );

        List<Integer> result2 = implementLFU(cacheSize2, queries2);
        System.out.println("Results: " + result2); // Expected: [1, -1, 2]
    }

    public static List<Integer> implementLFU(int cacheSize, List<String> queries) {
//        LFUCache cache = new LFUCache(cacheSize);
        LFUCache_Optimized cache = new LFUCache_Optimized(cacheSize);
        List<Integer> result = new ArrayList<>();

        for (String query : queries) {
            String[] parts = query.split(" ");

            if (parts[0].equals("PUT")) {
                int key = Integer.parseInt(parts[1]);
                int value = Integer.parseInt(parts[2]);
                cache.put(key, value);
            } else if (parts[0].equals("GET")) {
                int key = Integer.parseInt(parts[1]);
                int value = cache.get(key);
                result.add(value);
            }
        }

        return result;
    }
}


/*
Time Complexity:
GET: O(1) - HashMap operations are O(1)
PUT: O(n) in worst case - removeLFU() iterates through all keys to find minimum
Where n is the current number of elements in cache
Space Complexity:
O(capacity) - We store at most 'capacity' elements across three HashMaps
Each HashMap stores key-value pairs, so total space is 3 × capacity = O(capacity)
 */
class LFUCache {
    private int capacity;
    private Map<Integer, Integer> values;    // key -> value
    private Map<Integer, Integer> frequencies; // key -> frequency
    private Map<Integer, Integer> accessTime; // key -> last access time
    private int time; // global time counter

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.values = new HashMap<>();
        this.frequencies = new HashMap<>();
        this.accessTime = new HashMap<>();
        this.time = 0;
    }

    public int get(int key) {
        // If key doesn't exist, return -1
        if (!values.containsKey(key)) {
            return -1;
        }
        // Update frequency and access time
        frequencies.put(key, frequencies.get(key) + 1);
        accessTime.put(key, ++time);
        return values.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;
        // If key already exists, update value and frequency
        if (values.containsKey(key)) {
            values.put(key, value);
            frequencies.put(key, frequencies.get(key) + 1);
            accessTime.put(key, ++time);
            return;
        }
        // If cache is full, remove LFU (and LRU among ties)
        if (values.size() >= capacity) {
            removeLFU();
        }

        // Add new key-value pair
        values.put(key, value);
        frequencies.put(key, 1);
        accessTime.put(key, ++time);
    }

    private void removeLFU() {
        int minFreq = Integer.MAX_VALUE;
        int lfuKey = -1;
        int earliestTime = Integer.MAX_VALUE;

        // Find the key with minimum frequency
        // If tie, find the one with earliest access time (LRU)
        for (int key : frequencies.keySet()) {
            int freq = frequencies.get(key);
            int lastAccess = accessTime.get(key);

            if (freq < minFreq || (freq == minFreq && lastAccess < earliestTime)) {
                minFreq = freq;
                lfuKey = key;
                earliestTime = lastAccess;
            }
        }

        // Remove the LFU key
        values.remove(lfuKey);
        frequencies.remove(lfuKey);
        accessTime.remove(lfuKey);
    }
}
/*
Time Complexity:
GET: O(1)
HashMap get: O(1)
updateFrequency: O(1) - LinkedHashSet add/remove operations
PUT: O(1)
All HashMap operations: O(1)
LinkedHashSet operations: O(1)
removeLFU: O(1) - directly access minimum frequency group

Space Complexity:
O(capacity)
values HashMap: O(capacity)
frequencies HashMap: O(capacity)
freqGroups HashMap: O(capacity) - total keys across all frequency groups = capacity
Overall: O(capacity)
*/
class LFUCache_Optimized {
    private int capacity;
    private int minFreq; // Track minimum frequency
    private Map<Integer, Integer> values; // key -> value
    private Map<Integer, Integer> frequencies; // key -> frequency
    private Map<Integer, LinkedHashSet<Integer>> freqGroups; // freq -> keys with that freq

    public LFUCache_Optimized(int capacity) {
        this.capacity = capacity;
        this.minFreq = 1;
        this.values = new HashMap<>();
        this.frequencies = new HashMap<>();
        this.freqGroups = new HashMap<>();
    }

    public int get(int key) {
        // If key doesn't exist, return -1
        if (!values.containsKey(key)) {
            return -1;
        }
        // Update frequency of the key
        updateFrequency(key);
        return values.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;
        // If key already exists, update value and frequency
        if (values.containsKey(key)) {
            values.put(key, value);
            updateFrequency(key);
            return;
        }
        // If cache is full, remove LFU element
        if (values.size() >= capacity) {
            removeLFU();
        }
        // Add new key-value pair with frequency 1
        values.put(key, value);
        frequencies.put(key, 1);
        freqGroups.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        minFreq = 1; // New element always has frequency 1
    }

    private void updateFrequency(int key) {
        int oldFreq = frequencies.get(key);
        int newFreq = oldFreq + 1;
        // Update frequency
        frequencies.put(key, newFreq);
        // Remove from old frequency group
        freqGroups.get(oldFreq).remove(key);
        // If old frequency group is empty and it was minimum, update minFreq
        if (freqGroups.get(oldFreq).isEmpty() && oldFreq == minFreq) {
            minFreq++;
        }
        // Add to new frequency group
        freqGroups.computeIfAbsent(newFreq, k -> new LinkedHashSet<>()).add(key);
    }

    private void removeLFU() {
        // Get the LRU key from minimum frequency group
        // LinkedHashSet maintains insertion order, so first element is LRU
        int lfuKey = freqGroups.get(minFreq).iterator().next();
        // Remove from all data structures
        freqGroups.get(minFreq).remove(lfuKey);
        values.remove(lfuKey);
        frequencies.remove(lfuKey);
    }
}
