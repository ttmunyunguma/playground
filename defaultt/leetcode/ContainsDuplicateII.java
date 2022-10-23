package defaultt.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 219
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array
 * such that nums[i] == nums[j] and abs(i - j) <= k.
 * <p>
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * <p>
 * Example 2:
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * <p>
 * Example 3:
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(valueIndexMap.containsKey(nums[i])){
                if(Math.abs(valueIndexMap.get(nums[i]) - i) <= k)
                    return true;
                valueIndexMap.replace(nums[i], i);
            }else {
                valueIndexMap.put(nums[i], i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(new int[]{1,0,1,1}, 1));
    }
}
