
// program to find all subset sums
import java.util.*;

public class SubsetSumOne {

    public static void solve(int ind, int sum, ArrayList<Integer> arr, int N, ArrayList<Integer> sumSubset) {
        if (ind == N) {
            sumSubset.add(sum);
            return;
        }
        // Pick
        solve(ind + 1, sum + arr.get(ind), arr, N, sumSubset);
        // not Pick
        solve(ind + 1, sum, arr, N, sumSubset);
    }

    public static ArrayList<Integer> subsets(ArrayList<Integer> arr, int N) {

        ArrayList<Integer> ans = new ArrayList<>();
        solve(0, 0, arr, N, ans);
        Collections.sort(ans); 
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(1);
        arr.add(2);
        int N = arr.size();
        System.out.println(subsets(arr, N));
    }
}
