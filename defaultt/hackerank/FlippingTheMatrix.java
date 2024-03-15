package defaultt.hackerank;

import java.util.List;

public class FlippingTheMatrix {

    public static int flippingMatrix(List<List<Integer>> matrix) {
        // Write your code here

        return calculateMaxSum(matrix, matrix.size());
    }

    private static int calculateMaxSum(List<List<Integer>> matrix, int n) {
        int maxSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Identify the four elements for each quadrant
                int a = matrix.get(i).get(j);
                int b = matrix.get(i).get(2 * n - j - 1);
                int c = matrix.get(2 * n - i - 1).get(j);
                int d = matrix.get(2 * n - i - 1).get(2 * n - j - 1);

                // Get the maximum element from each quadrant
                int maxElement = Math.max(Math.max(a, b), Math.max(c, d));

                // Add the maximum element to the maximum sum
                maxSum += maxElement;
            }
        }
        return maxSum;
    }
}
