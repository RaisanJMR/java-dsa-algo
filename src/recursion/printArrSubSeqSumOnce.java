// @ program 3
//  @ print array subsequence equalls sum only once
import java.util.*;

public class printArrSubSeqSumOnce {
    public static boolean printSubsequences(int index, ArrayList<Integer> resArr, int iniSum, int sum, int arr[],
            int len) {
        if (index == len) {
            // condition satisfied
            if (iniSum == sum) {
                for (int i = 0; i < resArr.size(); i++) {
                    System.out.print(resArr.get(i) + " ");
                }
                // System.out.println();
                return true;
            } else
                return false;
        }
        resArr.add(arr[index]);
        iniSum = iniSum + arr[index];

        if (printSubsequences(index + 1, resArr, iniSum, sum, arr, len) == true) {
            return true;
        }

        iniSum = iniSum - arr[index];
        resArr.remove(resArr.size() - 1);

        if (printSubsequences(index + 1, resArr, iniSum, sum, arr, len) == true) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 1 };
        int len = arr.length;
        int sum = 2;
        ArrayList<Integer> resArr = new ArrayList<>();
        printSubsequences(0, resArr, 0, sum, arr, len);
    }
}
