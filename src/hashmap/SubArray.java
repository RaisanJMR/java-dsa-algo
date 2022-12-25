import java.util.*;

public class SubArray {
    // ! O(n)
    public static void main(String[] args) throws Exception {
        HashMap<Integer, Integer> map = new HashMap<>();
        // int arr[] = { 10, 2, -2, -20, 10 };// ans 3
        int arr[] = { 3, -1, 2, 5, -3 };// ans 3
        // int sum = -10;
        int sum = 2;
        map.put(0, 1);
        int ans = 0;
        int currSum = 0;
        for (int j = 0; j < arr.length; j++) {

            currSum = currSum + arr[j];
            int removeSum = currSum - sum;
            if (map.containsKey(removeSum)) {
                ans += map.get(removeSum);
            }

            if (map.containsKey(currSum)) {
                map.put(currSum, map.get(currSum) + 1);
            } else {
                map.put(currSum, 1);
            }

        }
        System.out.println(ans);
    }
}