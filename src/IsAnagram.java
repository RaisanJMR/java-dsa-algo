// 242. Valid Anagram
public class IsAnagram {

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        int count[] = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
            count[t.charAt(i)]--;

        }
        for (int i = 0; i < count.length; i++) {

            if (count[i] != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean data = isAnagram(s, t);
        System.out.println(data);
    }
}
