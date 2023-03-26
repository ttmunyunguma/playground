package defaultt.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all
 * the original letters exactly once.
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 * Constraints:
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */
public class ValidAnagram242 {

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            sMap.merge(s.charAt(i), 1, Integer::sum);
        }

        for (int i = 0; i < t.length(); i++) {
            tMap.merge(t.charAt(i), 1, Integer::sum);
        }

        if (sMap.size() == tMap.size()) {
            for (Map.Entry<Character,Integer> sMapEntry : sMap.entrySet()) {
                if(!tMap.containsKey(sMapEntry.getKey())){
                    return false;
                }
                if(!tMap.get(sMapEntry.getKey()).equals(sMapEntry.getValue())){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
