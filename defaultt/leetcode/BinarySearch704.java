package defaultt.leetcode;

/**
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search
 * target in nums. If target exists, then return its index. Otherwise, return -1.
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * Example 2:
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 *
 */
public class BinarySearch704 {

    public int search(int[] nums, int target) {
        int lowIndex = 0;
        int highIndex = nums.length - 1;
        while (lowIndex <= highIndex){
            int midPosition = (lowIndex + highIndex) / 2;
            if (nums[midPosition] == target)
                return midPosition;
            if (nums[midPosition] < target)
                lowIndex = midPosition + 1;
            else
                highIndex = midPosition - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new BinarySearch704().search(new int[]{-1,0,3,5,9,12}, 2));
    }
}
