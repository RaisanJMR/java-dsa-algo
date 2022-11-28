import java.util.*;

public class UnEqualTriplets {
    public static int unequalTriplets(int[] nums) {
        // Time: O(N); space: O(N)
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int num : nums)
        // map.put(num, map.getOrDefault(num, 0) + 1);

        // int res = 0;
        // int left = 0, right = nums.length;
        // Time: O(N)
        // leftCount * midCount * rightCount
        // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        // int midCount = entry.getValue();
        // right -= midCount;
        // res += left * midCount * right;

        // left += midCount;
        // }
        // return res;
        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                for (int k = j + 1; k < nums.length; ++k) {
                    if (nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k])
                        ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 4, 2, 4, 3 };
        int result = unequalTriplets(nums);
        System.out.println(result);
    }
}
