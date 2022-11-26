public class TwoSum2 {
    // https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
    public static int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (nums[l] + nums[r] != target) {
            if (nums[l] + nums[r] < target)
                l++;
            else
                r--;
        }

        return new int[] { l + 1, r + 1 };
    }

    // If our current sum is too small, move closer to the right(l++).
    // increment left pointer
    // If our current sum is too large, move closer to the left(r--).
    // decrement right pointer
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] data = twoSum(nums, target);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }
}
