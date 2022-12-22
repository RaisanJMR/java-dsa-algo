
public class Classroom {

    static class Node {
        Node[] children;
        boolean eow;

        public Node() {
            children = new Node[26];

            for (int i = 0; i < 26; i++) {
                children[i] = null;

            }
            eow = false;
        }
    }

    // created root var of type Node
    static Node root = new Node();

    // * INSERT O(L) -> length of string
    // a - a = 0
    // b - a = 1
    // c - a = 2
    // . - . = 3
    // . - . = 4
    // z - a = 25
    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                // add new node
                curr.children[idx] = new Node();
            }
            if (i == word.length() - 1) {
                curr.children[idx].eow = true;
            }
            curr = curr.children[idx];
        }
    }

    // * SEARCH
    // O(L)
    public static boolean search(String key) {
        Node curr = root;
        // System.out.println(curr);
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            Node node = curr.children[idx];
            if (node == null) {
                return false;
            }
            if (i == key.length() - 1 && node.eow == false) {
                return false;
            }

            curr = curr.children[idx];
        }

        return true;
    }

    // * WORD BREAK
    public static boolean wordBreak(String key) {
        if (key.length() == 0) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            String firstPart = key.substring(0, i);
            // System.out.println(firstPart);
            String secondPart = key.substring(i);
            // System.out.println(secondPart);
            if (search(firstPart) && wordBreak(secondPart)) {
                return true;
            }
        }
        return false;
    }

    // * Starts with
    public static boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    // * Unique substr
    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }
        return count + 1;
    }

    // * Longest word with all prefixes
    public static String ans = "";

    public static void longestWord(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].eow == true) {
                // * (char)(0+'a') = a
                // * (char)(1+'a') = b
                // * (char)(2+'a') = c
                temp.append((char) (i + 'a'));
                System.out.println(temp);
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        // ! String words[] = { "the", "a", "there", "their", "any" };
        // ! String words[] = { "i", "like", "sam", "samsung", "mobile", "ice" };

        // String key = "ilikesamsung";

        // ? INSERT
        // for (int i = 0; i < words.length; i++) {
        // insert(words[i]);
        // }

        // ? SEARCH
        // System.out.println(search("the"));
        // System.out.println(search("thor"));
        // System.out.println(search("an"));

        // ? WORD BREAK
        // System.out.println(wordBreak(key));

        // ? Starts with
        // String prefix = "saas";
        // System.out.println(startsWith(prefix));

        // ? Unique substr
        // String str = "ababa";
        // for (int i = 0; i < str.length(); i++) {
        // String suffix = str.substring(i);
        // System.out.println(suffix);
        // insert(suffix);
        // }
        // System.out.println(countNodes(root));

        // ? Longest word with all prefixes
        String words[] = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }

}
