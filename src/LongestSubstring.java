public class LongestSubstring {
    public static int longestUniqueSubsttr(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder currentSubstring = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                System.out.println("char at "+s.charAt(j));
                System.out.println("value of "+String.valueOf(s.charAt(j)));
                System.out.println("index of "+currentSubstring.indexOf(String.valueOf(s.charAt(j))));
                if (currentSubstring.indexOf(String.valueOf(s.charAt(j))) != -1) {

                    break;
                }
                currentSubstring.append(s.charAt(j));
                System.out.println("current string "+currentSubstring);
                maxLength = Math.max(maxLength, currentSubstring.length());
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String exp = "abcabcd";
        int len = longestUniqueSubsttr(exp);
        System.out.println(len);
    }
}
