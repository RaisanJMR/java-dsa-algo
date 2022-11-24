public class SampleOne {
    public static void main(String[] args) {
        String s = "anagram";
        int[] char_count = new int[26];
        int el = s.charAt(4) - 'a';
        System.out.print(char_count[el]--);
    }
}
