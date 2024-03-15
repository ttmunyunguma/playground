package defaultt.hackerank;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a list of integers, count and return the number of times each value appears as an array of integers.
 */
public class CountingSort1 {

    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        List<Integer> occurancesArr = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            occurancesArr.add(0);
        }

        for (int num : arr) {
            occurancesArr.set(num, occurancesArr.get(num) + 1);
        }
        return occurancesArr;
    }
}
