public class MaxProductSubArray {

    public static int maxProduct(int[] arr) {
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int prod = 1;
            for (int j = i; j < arr.length; j++) {
                prod *= arr[j];
                result = Math.max(result, prod);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 4};
        int maxProduct = maxProduct(arr);
        System.out.println("Maximum product subarray: " + maxProduct);
    }
}

