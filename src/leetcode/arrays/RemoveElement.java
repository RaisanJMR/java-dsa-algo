public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 2, 3 };
        int result = removeElement(arr, 3);
        System.out.print("Remaining elements: [");
        for (int i = 0; i < result; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.println("]");
        System.out.println("\nnumber of elements in array: " + result);
    }
}