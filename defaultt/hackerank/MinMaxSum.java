package defaultt.hackerank;

import java.util.List;

/**
 * Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of
 * the five integers. Then print the respective minimum and maximum values as a single line of two space-separated long
 * integers.
 */
public class MinMaxSum {

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        long minSum = Long.MAX_VALUE, maxSum = Long.MIN_VALUE;
        long totalSum = 0;
        for (int i = 0; i < 5; i++) {
            totalSum += arr.get(i);
            minSum = Math.min(minSum, arr.get(i));
            maxSum = Math.max(maxSum, arr.get(i));
        }

        // Output the minimum and maximum sums
        System.out.println((totalSum - maxSum) + " " + (totalSum - minSum));

    }

}
