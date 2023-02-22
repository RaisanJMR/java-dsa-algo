public class PalindromeRecursive {

    public static boolean isPalindrome(String str) {
        // Base case: If the string has 0 or 1 characters, it is a palindrome
        if (str.length() <= 1) {
            return true;
        }
        // Recursive case: Check if the first and last characters are the same,
        // and then recursively check the remaining substring
        char first = str.charAt(0);
        char last = str.charAt(str.length() - 1);
        if (first == last) {
            // If the first and last characters match, remove them from the string
            String subStr = str.substring(1, str.length() - 1);
            return isPalindrome(subStr);
        } else {
            // If the first and last characters do not match, the string is not a palindrome
            return false;
        }
    }

    public static void main(String[] args) {
        String str = "racecar";
        if (isPalindrome(str)) {
            System.out.println(str + " is a palindrome.");
        } else {
            System.out.println(str + " is not a palindrome.");
        }
    }

}
