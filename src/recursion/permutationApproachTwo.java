import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutations/
// second method

public class permutationApproachTwo {

    private static void recurPermute(int index, int[] num, List<List<Integer>> ans) {
        if (index == num.length) {
            // COPY ds to ans
            List<Integer> ds = new ArrayList<>();
            for (int i = 0; i < num.length; i++) {
                ds.add(num[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;

        }
        for (int i = index; i < num.length; i++) {
            swap(i, index, num);
            recurPermute(index + 1, num, ans);
            swap(i, index, num);
        }
    }

    private static void swap(int i, int j, int[] num) {
        int t = num[i];
        num[i] = num[j];
        num[j] = t;
    }

    private static List<List<Integer>> permute(int[] num) {
        List<List<Integer>> ans = new ArrayList<>();
        recurPermute(0, num, ans);
        return ans;
    }

    public static void main(String[] args) {
        int num[] = { 1, 2, 3 };
        System.out.println(permute(num));
    }

}
