package defaultt.leetcode;

/**
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 * Example 1:
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */
public class PalindromeNumber9 {
    public boolean isPalindrome(int x) {

        String xString = String.valueOf(x);

        for (int i = 0; i < xString.length() / 2; i++) {
            if(xString.charAt(i) != xString.charAt(xString.length() - 1 - i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeNumber9().isPalindrome(121121));
    }
}
