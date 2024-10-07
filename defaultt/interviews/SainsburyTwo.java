package defaultt.interviews;

import java.util.ArrayList;
import java.util.List;

/**
 * Your task is to output all numbers that have a certain number of digits where the following constraints apply.
 * <p>
 * The digits in the number must be in ascending order. A digit must be of the same or greater value than the preceding digit. So for a five digit number 12345; 11222 might be valid solutions but 12354; 11131 will never be valid.
 * Leading zeroes are not allowed i.e. 00123; 01234 are not valid solutions.
 * Your output must be in ascending order.
 * The maximum execution time for this challenge is 60 seconds.
 * <p>
 * INPUT
 * int: an integer. The required number of digits for the output values. The input value will be between 1 and 9.
 * <p>
 * OUTPUT
 * string: a string containing all the solutions in ascending order, separated by comma.
 * <p>
 * Example
 * INPUT
 * 2
 * <p>
 * OUTPUT
 * 11,12,13,14,15,16,17,18,19,22,23,24,25,26,27,28,29,33,34,35,36,37,38,39,44,45,46,47,48,49,55,56,57,58,59,66,67,68,69,77,78,79,88,89,99
 */
public class SainsburyTwo {

    public static String run(int input) {
        /*
         * Write your code below; return type and arguments should be according to the problem's requirements
         */
        List<String> result = new ArrayList<>();
        generateNumbers("", input, 1, result);
        return String.join(",", result);
    }

    private static void generateNumbers(String current, int digitsLeft, int startDigit, List<String> result) {
        if (digitsLeft == 0) {
            result.add(current);
            return;
        }

        for (int digit = startDigit; digit <= 9; digit++) {
            generateNumbers(current + digit, digitsLeft - 1, digit, result);
        }
    }

    public static void main(String[] args) {
        System.out.println(run(2)); // Example output
    }


}
