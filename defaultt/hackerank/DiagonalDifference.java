package defaultt.hackerank;

import java.util.List;

/**
 * Given a square matrix, calculate the absolute difference between the sums of its diagonals.
 */
public class DiagonalDifference {

    public static int diagonalDifference(List<List<Integer>> arr) {
        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;

        int n = arr.size();

        for (int i = 0; i < n; i++) {
            primaryDiagonalSum += arr.get(i).get(i);
            secondaryDiagonalSum += arr.get(i).get(n - 1 - i);
        }

        return Math.abs(primaryDiagonalSum - secondaryDiagonalSum);
    }
}
