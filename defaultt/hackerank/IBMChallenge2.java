package defaultt.hackerank;

import java.util.Collections;
import java.util.List;

public class IBMChallenge2 {

    public static int findMinimumCost(List<Integer> arr) {
        // Write your code here
        int minCost = Integer.MAX_VALUE;
        int minElement = Collections.min(arr);
        int maxElement = Collections.max(arr);

        // Iterate through each possible target value
        for (int target = minElement; target <= maxElement; target++) {
            int cost = 0;
            // Calculate the cost of making all elements equal to the target value
            for (int num : arr) {
                int diff = num - target;
                cost += Math.abs(diff);
            }
            // Update the minimum cost
            minCost = Math.min(minCost, cost);
        }

        return minCost;
    }
}
