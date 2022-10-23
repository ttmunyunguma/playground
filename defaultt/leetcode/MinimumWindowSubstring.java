package defaultt.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every
 * character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 * The testcases will be generated such that the answer is unique.
 * A substring is a contiguous sequence of characters within the string.
 * <p>
 * Example 1:
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * <p>
 * Example 2:
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * <p>
 * Example 3:
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABCB"));
    }

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }
        //map of all the characters needed i.e elements in t
        HashMap<Character, Integer> needMap = new HashMap<>();
        //keep track of window elements i.e 0 - size, 1 - start index, 2 - end index
        int[] desirableWindow = {-1, 0, 0};
        int rightPointer = 0, leftPointer = 0;
        //populate the needMap
        for (int i = 0; i < t.length(); i++) {
            needMap.merge(t.charAt(i), 1, Integer::sum);
        }
        //keeps track of unique elements in needMap
        int missingForDesirable = needMap.size();
        Map<Character, Integer> countsMap = new HashMap<>();

        while (rightPointer < s.length()) {
            //go with the right pointer and populate the countsMap as we go
            Character currentChar = s.charAt(rightPointer);
            int count = countsMap.getOrDefault(currentChar, 0);
            //if character already in map and 1 to the value
            countsMap.put(currentChar, count + 1);

            //if the character is both in needMap and countMap and has the same frequency, then its not missing anymore
            //from our window
            if (needMap.containsKey(currentChar) && (countsMap.get(currentChar).intValue() == needMap.get(currentChar).intValue())) {
                missingForDesirable--;
            }

            //when we have no more missing it means our current window has all the desired elements. Its time to shrink
            //the window by moving the left pointer
            while (missingForDesirable == 0 && (leftPointer <= rightPointer)) {
                if (desirableWindow[0] == -1 || rightPointer - leftPointer < desirableWindow[0]) {
                    desirableWindow[0] = rightPointer - leftPointer + 1;
                    desirableWindow[1] = leftPointer;
                    desirableWindow[2] = rightPointer;
                }

                currentChar = s.charAt(leftPointer);
                //remove from countsMap i.e shrink the window
                countsMap.replace(currentChar, countsMap.get(currentChar) - 1);
                //check if we have removed any desired character by shrinking
                if (needMap.containsKey(currentChar) && (countsMap.get(currentChar) < needMap.get(currentChar))) {
                    missingForDesirable++;
                }
                leftPointer++;
            }
            rightPointer++;
        }

        return desirableWindow[0] == -1 ? "" : s.substring(desirableWindow[1], desirableWindow[2] + 1);
    }
}




