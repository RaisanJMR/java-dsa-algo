
// https://leetcode.com/problems/combination-sum/
// @no need static reference in leetcode
import java.util.*;

public class CombinationSumOne {
    /**
     * @param index
     * @param arr
     * @param target
     * @param ans
     * @param ds
     */
    public static void findCombinations(int index, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (index == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return; 
        }
        // @pick
        if (arr[index] <= target) {
            ds.add(arr[index]);
            findCombinations(index, arr, target - arr[index], ans, ds);
            ds.remove(ds.size() - 1);
        }
        findCombinations(index + 1, arr, target, ans, ds);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
        int candidates[] = { 2, 3, 6, 7 };
        int target = 7;
        System.out.println(combinationSum(candidates, target));

    }
}
