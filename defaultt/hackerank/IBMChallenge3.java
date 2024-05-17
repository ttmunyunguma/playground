package defaultt.hackerank;

import java.util.List;

public class IBMChallenge3 {

    public static void main(String[] args) {
        List<Integer> arr1 = List.of(5, 1, 2, 6, 4);

        System.out.println(minDeletions(arr1)); // 1
    }

    public static int minDeletions(List<Integer> arr) {
        int length = arr.size();
        int violationIndex = -1;

        // Find the first violation of the sorted order
        for (int i = 0; i < length - 1; i++) {
            if (arr.get(i) > arr.get(i + 1)) {
                if (violationIndex != -1) {
                    // If there's already a violation, more than one element needs to be removed
                    return 2;
                }
                violationIndex = i;
            }
        }

        // If no violation found, the array is already sorted
        if (violationIndex == -1) {
            return 0;
        }

        // Check if the array can be sorted by removing one element
        if (isSortedAfterRemovingElement(arr, violationIndex) || isSortedAfterRemovingElement(arr, violationIndex + 1)) {
            return 1;
        }

        return 2;
    }

    private static boolean isSortedAfterRemovingElement(List<Integer> arr, int index) {
        int n = arr.size();
        for (int i = 0; i < n - 1; i++) {
            if (i == index) {
                if (i > 0 && i + 1 < n && arr.get(i - 1) > arr.get(i + 1)) {
                    return false;
                }
            } else if (i + 1 == index) {
                if (i + 2 < n && arr.get(i) > arr.get(i + 2)) {
                    return false;
                }
            } else if (i < n - 1 && arr.get(i) > arr.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

}
