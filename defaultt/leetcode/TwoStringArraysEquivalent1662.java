package defaultt.leetcode;

/**
 * Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
 * A string is represented by an array if the array elements concatenated in order forms the string.
 *
 * Example 1:
 * Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
 * Output: true
 * Explanation:
 * word1 represents string "ab" + "c" -> "abc"
 * word2 represents string "a" + "bc" -> "abc"
 * The strings are the same, so return true.
 *
 * Example 2:
 * Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
 * Output: false
 *
 * Example 3:
 * Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 * Output: true
 */
public class TwoStringArraysEquivalent1662 {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        StringBuilder stringWord1 = new StringBuilder("");
        StringBuilder stringWord2 = new StringBuilder("");

        for (String s : word1) {
            stringWord1.append(s);
        }
        for (String s : word2) {
            stringWord2.append(s);
        }

        return stringWord1.toString().equals(stringWord2.toString());
    }

    public static void main(String[] args) {
        System.out.println(new TwoStringArraysEquivalent1662().arrayStringsAreEqual(new String[]{"abc", "d", "defg"}, new String[]{"abcddefg"}));
    }

}
