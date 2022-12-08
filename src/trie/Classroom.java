
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

    // INSERT O(L) -> length of string
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

    // SEARCH
    // O(L)
    public static boolean search(String key) {
        Node curr = root;
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

    public static void main(String[] args) {
        String words[] = { "the", "a", "there", "their", "any" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        System.out.println(search("the"));
        System.out.println(search("thor"));
        System.out.println(search("an"));
    }
}
