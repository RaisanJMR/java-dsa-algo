import java.util.*;


// Three sum in java
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int last = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != last) {
                int start = i + 1;
                int end = nums.length - 1;
                while (start < end) {
                    if ((nums[i] + nums[start] + nums[end]) == 0) {
                        ArrayList<Integer> ar = new ArrayList<Integer>();
                        ar.add(nums[i]);
                        ar.add(nums[start]);
                        ar.add(nums[end]);
                        res.add(ar);
                        int temp = nums[start];
                        start++;
                        while (start < end && nums[start] == temp)
                            start++;
                    } else if ((nums[i] + nums[start] + nums[end]) < 0) {
                        start++;
                    } else
                        end--;
                }
            }
            last = nums[i];
        }
        return res;

    }

    public static void main(String[] args) {
        int nums[] = { -1, 0, 1, 2, -1, -4 };
        ThreeSum th = new ThreeSum();
        List<List<Integer>> data = th.threeSum(nums);
        System.out.println(data);
    }
}
