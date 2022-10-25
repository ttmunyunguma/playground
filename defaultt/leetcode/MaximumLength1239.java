package defaultt.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has
 * unique characters. Return the maximum possible length of s.
 * A subsequence is an array that can be derived from another array by deleting some or no elements without changing the
 * order of the remaining elements.
 * <p>
 * Example 1:
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All the valid concatenations are:
 * - ""
 * - "un"
 * - "iq"
 * - "ue"
 * - "uniq" ("un" + "iq")
 * - "ique" ("iq" + "ue")
 * Maximum length is 4.
 * <p>
 * Example 2:
 * Input: arr = ["cha","r","act","ers"]
 * Output: 6
 * Explanation: Possible longest valid concatenations are "chaers" ("cha" + "ers") and "acters" ("act" + "ers").
 * <p>
 * Example 3:
 * Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
 * Output: 26
 * Explanation: The only string in arr has all 26 characters.
 */
public class MaximumLength1239 {

    public static void main(String[] args) {
        System.out.println(new MaximumLength1239().maxLength(List.of("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p")));
    }

    public int maxLength(List<String> arr) {

        if(arr.isEmpty())
            return 0;

        String[] stringsArray = arr.toArray(new String[0]);

        if(stringsArray.length == 1 && stringsArray[0].equals(""))
            return 0;

        Map<String, Integer> uniqueWordLengthMap = new HashMap<>();

        //TODO Check for consecutive word combinations

        for (int i = 0; i < stringsArray.length; i++) {
            if (checkUniqueCharsOnly(stringsArray[i])) {
                uniqueWordLengthMap.put(stringsArray[i], stringsArray[i].length());
            }
            int j = i + 1;
            while (j < stringsArray.length) {
                String temp = stringsArray[i] + stringsArray[j];
                if (checkUniqueCharsOnly(temp)) {
                    uniqueWordLengthMap.put(temp, temp.length());
                }
                j++;
            }
        }
        System.out.println(uniqueWordLengthMap);
        return uniqueWordLengthMap.values().stream().mapToInt(x -> x).max().orElse(0);
    }

    boolean checkUniqueCharsOnly(String testString) {
        char[] chars = testString.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int j = i + 1;
            while (j < chars.length) {
                if (chars[i] == chars[j]) {
                    return false;
                }
                j++;
            }
        }
        return true;
    }
}






