
// @ program 4
//@ count the number of subsequence with sum K
// @ TC 2^n
public class ArraySubsequenceCount {
    public static int printSubsequences(int index, int iniSum, int sum, int arr[],
            int len) {
        if (index == len) {
            // condition satisfied
            if (iniSum == sum) {
                return 1;
            } else
                return 0;
        }

        iniSum = iniSum + arr[index];

        int l = printSubsequences(index + 1, iniSum, sum, arr, len);

        iniSum = iniSum - arr[index];

        int r = printSubsequences(index + 1, iniSum, sum, arr, len);
    
        return l + r;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 1 };
        int len = arr.length;
        int sum = 2;
        int res = printSubsequences(0, 0, sum, arr, len);
        System.out.println(res);
    }
}
