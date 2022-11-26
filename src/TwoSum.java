import java.util.*;

// https://leetcode.com/problems/two-sum/description/
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < n; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    // Time Complexity: O(n)
    // Space: O(n)
    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 17;
        int[] data = twoSum(nums, target);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }
}
