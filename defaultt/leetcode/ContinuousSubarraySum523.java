package defaultt.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an integer array nums and an integer k, return true if nums has a continuous subarray of size at least two whose
 * elements sum up to a multiple of k, or false otherwise.
 * An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 *
 * Example 1:
 * Input: nums = [23,2,4,6,7], k = 6
 * Output: true
 * Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
 *
 * Example 2:
 * Input: nums = [23,2,6,4,7], k = 6
 * Output: true
 * Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
 * 42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
 *
 * Example 3:
 * Input: nums = [23,2,6,4,7], k = 13
 * Output: false
 */
public class ContinuousSubarraySum523 {

    public boolean checkSubarraySum(int[] nums, int k) {

//        if(nums.length < 2)
//            return false;
//
//        for (int i = 0; i < nums.length - 1; i++) {
//            List<Integer> temp = new ArrayList<>();
//            int count = i;
//            temp.add(nums[count++]);
//            while (count < nums.length){
//                temp.add(nums[count]);
//                if(temp.stream().reduce(Integer::sum).get() % k == 0 )
//                    return true;
//                count++;
//            }
//            temp.clear();
//        }
//        return false;

        for(int i=1;i<nums.length;i++) {
            if(nums[i] == 0 && nums[i-1] == 0) return true;
        }
        for(int i=1;i<nums.length;i++) {
            nums[i] += nums[i-1];
            if(nums[i] % k ==0) return true;
            int j = i;
            while(j> 1 && nums[i] > k) {
                if((nums[i] - nums[j-2]) % k ==0) {
                    return true;
                }
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ContinuousSubarraySum523().checkSubarraySum(new int[]{23,2,4,6,7}, 6));
    }
}
