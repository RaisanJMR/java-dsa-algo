import java.util.Random;

public class SelectionSort {
    
    // Best case O(n^2)
    // Average case O(n^2)
    // Worst case O(n^2)
    public static void selectionSort(int[] inputArray) {

        for (int i = 0; i < inputArray.length; i++) {
            int smallest = i;
            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[smallest] > inputArray[j]) {
                    smallest = j;
                }
            }
            int temp = inputArray[smallest];
            inputArray[smallest] = inputArray[i];
            inputArray[i] = temp;
        }

    }

    // PRINT ARRAY
    public static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " \t");
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

        selectionSort(numbers);

        System.out.println("\nAfter");
        printArray(numbers);
    }
}
