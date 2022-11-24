import java.util.Arrays;

class IsAnagramOne {
    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null)
            return false;

        if (s.length() != t.length())
            return false;

        String firstSort = sortString(s);
        String secondSort = sortString(t);
        return firstSort.equals(secondSort);
    }

    private static String sortString(String s) {
        char[] chars = s.toCharArray();
       Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean data = isAnagram(s, t);
        System.out.println(data);
    }
}
