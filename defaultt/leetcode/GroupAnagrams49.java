package defaultt.leetcode;

import java.util.*;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using
 * all the original letters exactly once.
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 */
public class GroupAnagrams49 {

    public static void main(String[] args) {
        new GroupAnagrams49().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> stringListMap = new HashMap<>();
        for (String s : strs) {
            char[] key = s.toCharArray();
            Arrays.sort(key);
            String sortedKey = new String(key);

            List<String> tempList = stringListMap.getOrDefault(sortedKey, new ArrayList<>());
            tempList.add(s);
            stringListMap.put(sortedKey, tempList);
        }
        return stringListMap.values().stream().toList();
    }
}
