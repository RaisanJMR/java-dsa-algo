import java.sql.Time;

public class GenerateSubArrays {
    // BRUTE FORCE
    // APPROACH 1 O^3

    // public static int generateAllSubArrays(int[] arr) {
    // int result = Integer.MIN_VALUE;
    // for (int i = 0; i < arr.length; i++) {
    // for (int j = i; j < arr.length; j++) {
    // System.out.print("[ ");
    // int prod = 1;
    // for (int k = i; k <= j; k++) {
    // prod *= arr[k];
    // result = Math.max(result, prod);
    // System.out.print(arr[k] + " ");
    // }
    // System.out.println("]");
    // }
    // }
    // return result;
    // }

    // APPROACH 2 O^2
    // Time Complexity: O(N2)

    // Reason: We are using two nested loops

    // Space Complexity: O(1)

    // Reason: No extra data structures are used for computation
    // public static int generateAllSubArrays(int[] arr) {
    // int result = arr[0];
    // for (int i = 0; i < arr.length - 1; i++) {
    // int p = arr[i];
    // for (int j = i + 1; j < arr.length; j++) {
    // p *= arr[j];
    // result = Math.max(result, p);
    // }
    // result = Math.max(result, p);
    // }
    // return result;
    // }

    // APPROACH 3
    // Time Complexity: O(N), N = size of the given array.
    // Reason: We are using a single loop that runs for N times.
    // Space Complexity: O(1) as No extra data structures are used for computation.
    public static int generateAllSubArrays(int[] arr) {
        int n = arr.length; // size of array.

        int pre = 1, suff = 1;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (pre == 0)
                pre = 1;
            if (suff == 0)
                suff = 1;
            pre *= arr[i];
            suff *= arr[n - i - 1];
            ans = Math.max(ans, Math.max(pre, suff));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        int answer = generateAllSubArrays(arr);
        System.out.print("The maximum product subarray is: " + answer);
    }
}
