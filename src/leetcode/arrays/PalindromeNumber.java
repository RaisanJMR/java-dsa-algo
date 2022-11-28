

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        int number = x;
        int reverse = 0;
        while (x > 0) {
            reverse = x % 10 + reverse * 10;
            x = x / 10;
        }
        return reverse == number ? true : false;
    }

    public static void main(String[] args) {
        boolean result = isPalindrome(121);
        System.out.println(result);
    }
}
