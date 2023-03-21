// @ program 2
// @ O(2^n)
// @ print array subsequence sum equals k
import java.util.*;

public class ArraySubsequenceSum {

    /**
     * @param index
     * @param resArr
     * @param iniSum
     * @param sum
     * @param arr
     * @param len
     */
    public static void printSubsequences(int index, ArrayList<Integer> resArr, int iniSum, int sum, int arr[],
            int len) {
        if (index == len) {
            if (iniSum == sum) {
                for (int i = 0; i < resArr.size(); i++) {
                    System.out.print(resArr.get(i) + " ");
                }
                System.out.println();
            }

            return;
        }
        resArr.add(arr[index]);
        iniSum = iniSum + arr[index];

        printSubsequences(index + 1, resArr, iniSum, sum, arr, len);

        iniSum = iniSum - arr[index];
        resArr.remove(resArr.size() - 1);

        printSubsequences(index + 1, resArr, iniSum, sum, arr, len);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 1 };
        int len = arr.length;
        int sum = 2;
        ArrayList<Integer> resArr = new ArrayList<>();
        printSubsequences(0, resArr, 0, sum, arr, len);
    }

}
