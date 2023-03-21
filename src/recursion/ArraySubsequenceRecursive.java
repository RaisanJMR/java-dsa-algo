
// @ O(2^n)
// @ for every element two options (2^n)*n
// @ n os for {for loop}
// @ space complexity is O(N) it is the depth of recursion tree 
// @ maximum wait in recursion tree is max of 3 stack's
// @ pg 1 (L6)

import java.util.*;

public class ArraySubsequenceRecursive {

    public static void printSubsequences(int[] arr, int index, ArrayList<Integer> path) {

        if (index == arr.length) {
            // Base case: Print the subsequence and return
            if (path.size() >= 0)
                System.out.println(path);
        } else {

            path.add(arr[index]);

            // Subsequence without including
            // the element at current index
            printSubsequences(arr, index + 1, path);

            // Backtrack to remove the recently
            // inserted element
            path.remove(path.size() - 1);

            // Subsequence including the element
            // at current index
            printSubsequences(arr, index + 1, path);
        }

        return;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2 };
        ArrayList<Integer> path = new ArrayList<>();
        printSubsequences(arr, 0, path);
    }

}
