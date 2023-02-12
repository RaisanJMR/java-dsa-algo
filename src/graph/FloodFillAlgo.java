// @ Flood Fill algo 733 LTC
// @ Time Complexity: O(NxM + NxMx4) ~ O(N x M)
public class FloodFillAlgo {
    /**
     * @param row
     * @param col
     * @param ans
     * @param image
     * @param newColor
     * @param delRow
     * @param delCol
     * @param iniColor
     */
    public void dfs(int row, int col, int ans[][], int image[][], int newColor, int delRow[], int delCol[],
            int iniColor) {

        // give new color to the current cell
        ans[row][col] = newColor;

        int n = image.length;
        int m = image[0].length;

        // each cell has 4 neighbours
        for (int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            // @check that co-ordinate is valid
            // @check same initial color and unvisited pixel
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == iniColor
                    && ans[nrow][ncol] != newColor) {
                dfs(nrow, ncol, ans, image, newColor, delRow, delCol, iniColor);
            }
        }

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // get initial color
        int iniColor = image[sr][sc];
        int ans[][] = image;

        // delta row and column for neighbours
        int delRow[] = { -1, 0, +1, 0 };
        // @ int delRow[] = { up(-1), right(0), down(+1), left(0) };
        int delCol[] = { 0, +1, 0, -1 };

        dfs(sr, sc, ans, image, newColor, delRow, delCol, iniColor);
        return ans;

    }

    public static void main(String[] args) {
        int[][] image = {
                { 1, 1, 1 },
                { 1, 1, 0 },
                { 1, 0, 1 }
        };
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        FloodFillAlgo obj = new FloodFillAlgo();
        int ans[][] = obj.floodFill(image, sr, sc, newColor);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
