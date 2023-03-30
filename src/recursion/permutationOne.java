
// https://leetcode.com/problems/permutations/
import java.util.*;

public class permutationOne {
    public static void recuPermute(int num[], List<Integer> ds, List<List<Integer>> ans, boolean freq[]) {
        if (ds.size() == num.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                ds.add(num[i]);
                recuPermute(num, ds, ans, freq);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }

    public static List<List<Integer>> permute(int num[]) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean freq[] = new boolean[num.length];
        recuPermute(num, ds, ans, freq);
        return ans;
    }

    public static void main(String[] args) {
        int num[] = { 1, 2, 3 };
        System.out.println(permute(num));
    }
}
