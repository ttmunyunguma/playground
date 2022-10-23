package defaultt.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error,
 * one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss
 * of another number.
 * You are given an integer array nums representing the data status of this set after the error.
 * Find the number that occurs twice and the number that is missing and return them in the form of an array.
 * <p>
 * Example 1:
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 * <p>
 * Example 2:
 * Input: nums = [1,1]
 * Output: [1,2]
 */

public class SetMismatch {
    public int[] findErrorNums(int[] nums) {

        if (nums.length < 2)
            return new int[0];

        int[] resultingArray = new int[2];
        Map<Integer, Integer> numsMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            numsMap.merge(nums[i], 1, Integer::sum);
        }
        for (int j = 1; j <= numsMap.size() + 1; j++) {
            if(numsMap.containsKey(j)){
                if(numsMap.get(j) > 1){
                    resultingArray[0] = j;
                }
            }else {
                resultingArray[1] = j;
            }
        }
        return resultingArray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SetMismatch().findErrorNums(new int[]{1,2,2,4})));
    }
}
