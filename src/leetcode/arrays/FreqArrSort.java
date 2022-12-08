import java.util.*;

// https://leetcode.com/problems/sort-array-by-increasing-frequency/
public class FreqArrSort {
    public static int[] freqSort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for (int n : nums) { // O(n)
            ans.add(n);
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        // System.out.println(ans);
        // returns a negative, 0, a positive if the current value is less than,
        // equal to, or greater than the value we are comparing with, respectively

        // compareFn(a, b) return value sort order
        // > 0 sort a after b
        // < 0 sort a before b
        // === 0 keep original order of a and b
        Collections.sort(ans, (a, b) -> { // O(n * logn)
            // System.out.println("a-> " + a + " " + map.get(a));
            // System.out.println("b-> " + b + " " + map.get(b));
            // System.out.println(map.get(a) == map.get(b) ? b - a
            // : map.get(a) -
            // map.get(b));
            if (map.get(a) == map.get(b)) {
                return b - a;
            } else {
                return map.get(a) - map.get(b);
            }

            // return map.get(a) == map.get(b) ? b - a : map.get(a) - map.get(b);
        });
        // System.out.println("answer" + ans);

        return ans.stream().mapToInt(i -> i).toArray(); // O(n)
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 2, 2, 3 };
        int[] result = freqSort(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
