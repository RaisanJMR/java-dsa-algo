import java.util.*;

public class bTwo {
    public static int[] reverseArray(int a[], int start, int end) {
        if (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            reverseArray(a, start + 1, end - 1);
        }
        return a;
    }

    public static void main(String[] args) {
        // declare array
        int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
        int length = arr.length;
        int[] revArray = reverseArray(arr, 0, length - 1);
        for (int i : revArray) {
            System.out.print(i + "  ");
        }
    }
}
