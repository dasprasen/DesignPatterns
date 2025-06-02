package com.problems.arrays_and_strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring_1("pwwkew"));
        System.out.println(lengthOfLongestSubstring_2("pwwkew"));
    }

    // Time: O( 2*N ) Space: O(N)
    public static int lengthOfLongestSubstring_1(String s) {
        if(s.length()==0)
            return 0;
        int maxLen = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        int l=0;
        for(int r=0;r<s.length();r++) {
            if (set.contains(s.charAt(r))) {
                while(l < r && set.contains(s.charAt(r))) {
                    set.remove(s.charAt(l));
                    l++;
                }
            }
            set.add(s.charAt(r));
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }

    public static int lengthOfLongestSubstring_2(String s) {
        if (s.length() == 0)
            return 0;

        int maxLen = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        for (int right = 0, left = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if(charIndexMap.containsKey(currentChar)) {
                left = Math.max(left, charIndexMap.get(currentChar) + 1);
            }
            charIndexMap.put(currentChar, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
