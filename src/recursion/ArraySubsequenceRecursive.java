import java.util.*;
// @ O(2^n)
public class ArraySubsequenceRecursive {

    public static void printSubsequences(int[] arr, int index, ArrayList<Integer> path) {

        if (index == arr.length) {
            // Base case: Print the subsequence and return
            if (path.size() >= 0)
                System.out.println(path);
        } else {
            // Subsequence without including
            // the element at current index
            printSubsequences(arr, index + 1, path);

            path.add(arr[index]);

            // Subsequence including the element
            // at current index
            printSubsequences(arr, index + 1, path);

            // Backtrack to remove the recently
            // inserted element
            path.remove(path.size() - 1);
        }
        return;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2 };
        ArrayList<Integer> path = new ArrayList<>();
        printSubsequences(arr, 0, path);
    }

}
