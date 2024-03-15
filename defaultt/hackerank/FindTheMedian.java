package defaultt.hackerank;

import java.util.Collections;
import java.util.List;

public class FindTheMedian {
    public static int findMedian(List<Integer> arr) {
        // Write your code here
// Sort the array
        Collections.sort(arr);

        // Find the median
        int median = 0;
        int n = arr.size();

        if (n % 2 == 0) {
            median = (arr.get(n / 2 - 1) + arr.get(n / 2)) / 2;
        } else {
            median = arr.get(n / 2);
        }


        return median;

    }
}
