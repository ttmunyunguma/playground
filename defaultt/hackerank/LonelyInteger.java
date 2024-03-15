package defaultt.hackerank;

import java.util.List;

/**
 * Given an array of integers, where all elements but one occur twice, find the unique element.
 */
public class LonelyInteger {

    public static int lonelyinteger(List<Integer> a) {
        // Write your code here

        int result = 0;
        for (int num : a) {
            result ^= num;
        }
        return result;
    }

}
