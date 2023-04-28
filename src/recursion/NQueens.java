import java.util.*;

// https://leetcode.com/problems/n-queens/
public class NQueens {

    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> ans = new ArrayList<List<String>>();
        solve(0, board, ans);
        return ans;
    }

    static boolean isSafe(char[][] board, int row, int col) {
        int duprow = row;
        int dupcol = col;
        // diag left up
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            row--;
            col--;
        }

        row = duprow;
        col = dupcol;
        // left column
        while (col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            col--;
        }

        row = duprow;
        col = dupcol;
        // diag left down
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q')
                return false;
            row++;
            col--;
        }
        return true;
    }

    static void solve(int col, char[][] board, List<List<String>> ans) {
        // base case
        if (col == board.length) {
            ans.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                solve(col + 1, board, ans);
                board[row][col] = '.';
            }
        }
    }

    static List<String> construct(char[][] board) {
        List<String> ans = new LinkedList<String>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            ans.add(s);
        }
        return ans;
    }

    public static void main(String args[]) {
        int N = 4;
        List<List<String>> queen = solveNQueens(N);
        int i = 1;
        for (List<String> it : queen) {
            System.out.println("Arrangement " + i);
            for (String s : it) {
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }

    }

}
