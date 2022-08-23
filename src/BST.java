// Binary Search Tree

public class BST {
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

    // Search
    public static boolean search(Node root, int key) {
        // O(H)
        if (root == null) {
            return false;
        }
        if (root.data > key) {
            return search(root.left, key);
        } else if (root.data == key) {
            return true;
        } else {
            return search(root.right, key);
        }
    }

    // Delete [IMPORTANT]
    public static Node deleteNode(Node root, int val) {
        if (root.data > val) {
            root.left = deleteNode(root.left, val);
        } else if (root.data < val) {
            root.right = deleteNode(root.right, val);
        } else {
            // root.data == val
            
            // CASE 1
            if (root.left == null && root.right == null) {
                return null;
            }

            // CASE 2 only one child (LEFT || RIGHT)
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // CASE 3 finding inOrderSuccessor() and deleting
            Node IN_ORDER_SUCC = inOrderSuccessor(root.right);
            root.data = IN_ORDER_SUCC.data;
            root.right = deleteNode(root.right, IN_ORDER_SUCC.data);
        }
        return root;
    }

    public static Node inOrderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
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

    public static void main(String[] args) {
        // int values[] = { 5, 1, 3, 4, 2, 7 };
        int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inOrder(root);
        System.out.println();
        // Search in bst

        // if (search(root, 18)) {
        // System.out.println("found");
        // } else {
        // System.out.println("not found");
        // }

        deleteNode(root, 5);
        inOrder(root);

    }
}
