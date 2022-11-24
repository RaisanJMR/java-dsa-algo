import java.util.Random;

public class InsertionSort {
// Best case O(n)
// Average case O(n^2)
// Worst case O(n^2)
    public static void insertionSort(int[] inputArray) {
        for (int i = 1; i < inputArray.length; i++) {
            int currValue = inputArray[i];
            int j = i - 1;
            while (j >= 0 && inputArray[j] > currValue) {
                inputArray[j + 1] = inputArray[j];
                j--;
            }
            inputArray[j + 1] = currValue;
        }
    }

    // PRINT ARRAY
    public static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }
        System.out.println("Before");
        printArray(numbers);

        insertionSort(numbers);

        System.out.println("\nAfter");
        printArray(numbers);
    }
}
