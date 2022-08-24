
// To print values of a binary tree in range

public class BSTPrintInRange {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // Insert
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    // Print
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // Print in Range
    public static void printInRange(Node root, int X, int Y) {
        if (root == null) {
            return;
        }
        // 6(X) 8(root) 10(Y)
        if (root.data >= X && root.data <= Y) {
            printInRange(root.left, X, Y);
            System.out.print(root.data + " ");
            printInRange(root.right, X, Y);

        } else if (root.data >= Y) {
            printInRange(root.left, X, Y);
            
        } else {
            printInRange(root.right, X, Y);
        }
    }

    public static void main(String[] args) {
        int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inOrder(root);
        System.out.println();

        printInRange(root, 5, 13);
        System.out.println();

    }
}
