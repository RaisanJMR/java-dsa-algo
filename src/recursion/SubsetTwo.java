
// https://leetcode.com/problems/subsets/
// Given an integer array nums of unique elements, return all possible 
// subsets
//  (the power set).

// The solution set must not contain duplicate subsets. Return the solution in any order.
import java.util.*;

public class SubsetTwo {
    public static void solve(int ind, int[] nums, ArrayList<Integer> temp, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(temp));
        for (int i = ind; i < nums.length; i++) {
            if (i != ind && nums[i] == nums[i - 1])
                continue;// for duplicate checking
            temp.add(nums[i]);
            solve(i + 1, nums, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums); 
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    public static void main(String[] args) {

        int num[] = { 1, 2, 3 };
        System.out.println(subsets(num));
    }

}
