package defaultt.hackerank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero. Print the
 * decimal value of each fraction on a new line with  places after the decimal.
 * Note: This challenge introduces precision problems. The test cases are scaled to six decimal places, though answers
 * with absolute error of up to  are acceptable.
 */
public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        ResultPlusMinus.plusMinus(arr);

        bufferedReader.close();
    }
}

class ResultPlusMinus {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here

        // Count positive, negative, and zero elements
        int positiveCount = 0, negativeCount = 0, zeroCount = 0;
        int n = arr.size();
        for (int i = 0; i < n; i++) {
            if (arr.get(i) > 0) {
                positiveCount++;
            } else if (arr.get(i) < 0) {
                negativeCount++;
            } else {
                zeroCount++;
            }
        }

        // Calculate ratios
        double positiveRatio = (double) positiveCount / n;
        double negativeRatio = (double) negativeCount / n;
        double zeroRatio = (double) zeroCount / n;

        // Print ratios with 6 decimal places
        System.out.printf("%.6f\n", positiveRatio);
        System.out.printf("%.6f\n", negativeRatio);
        System.out.printf("%.6f\n", zeroRatio);
    }

}
