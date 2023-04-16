package defaultt.leetcode;

import java.util.Arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 */
public class LongestCommonPrefix14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length <= 1)
            return strs[0];

        Arrays.sort(strs);
        String firstString = strs[0];
        String lastString = strs[strs.length - 1];
        int maxSize = 0;

        if(firstString.length() == 0){
            return firstString;
        }

        while (maxSize < firstString.length() && maxSize < lastString.length()){
            if(firstString.charAt(maxSize) != lastString.charAt(maxSize)){
                break;
            }
            maxSize++;
        }
        return firstString.substring(0, maxSize);
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix14().longestCommonPrefix(new String[]{"ab", "a"}));
    }
}
