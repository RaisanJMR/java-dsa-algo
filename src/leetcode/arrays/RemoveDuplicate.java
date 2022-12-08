// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

public class RemoveDuplicate {
    public static int removeDuplicates(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; ++i)
            if (nums[i] != nums[i - 1])
                nums[k++] = nums[i];
        return k;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int result = removeDuplicates(arr);
        System.out.println(result);

    }
}
