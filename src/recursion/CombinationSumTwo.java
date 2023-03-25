
// https://leetcode.com/problems/combination-sum-ii/
import java.util.*;

public class CombinationSumTwo {
    public static void findCombinations(int index, int arr[], int target, List<List<Integer>> ans, List<Integer> ds) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1])
                continue;
            if (arr[i] > target)
                break;

            ds.add(arr[i]);
            findCombinations(i + 1, arr, target - arr[i], ans, ds);
            ds.remove(ds.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
 
    public static void main(String[] args) {
        int candidates[] = { 1, 1, 1, 2, 2 };
        int target = 4;
        System.out.println(combinationSum2(candidates, target));
    }
}
