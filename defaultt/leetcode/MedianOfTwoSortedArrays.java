package defaultt.leetcode;


import java.util.Arrays;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 *
 * Example 2:
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 * Constraints:
 * nums1.length == m , nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 *
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = new int[nums1.length+nums2.length];
        double medianValue = 0.0;
        for (int i = 0; i < nums1.length; i++) {
            mergedArray[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            mergedArray[nums1.length+i] = nums2[i];
        }
        Arrays.sort(mergedArray);
        if(mergedArray.length % 2 == 0){
            medianValue = ( (double) mergedArray[mergedArray.length/2] + mergedArray[(mergedArray.length/2) - 1]) / 2;
        } else {
            medianValue = mergedArray[mergedArray.length/2];
        }
        return medianValue;
    }


    public static void main(String[] args) {
        new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1,2, 9}, new int[]{3, 4, 5});
    }
}
