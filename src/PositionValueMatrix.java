public class PositionValueMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 2, 0, 3 },
                { 0, 2, 0 },
                { 4, 0, 2 }
        };

        int[][] positionMatrix = posValueMatrix(matrix);

        // Print the position value matrix
        for (int i = 0; i < positionMatrix.length; i++) {
            for (int j = 0; j < positionMatrix[i].length; j++) {
                System.out.print(positionMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] posValueMatrix(int[][] matrix) {
        int[][] positionMatrix = new int[matrix.length][matrix[0].length];

        // Traverse the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // Calculate the position value
                if (matrix[i][j] != 0) {
                    int positionValue = matrix[i][j] + i + j;
                    // Store the position value in the position matrix
                    positionMatrix[i][j] = positionValue;
                }
            }
        }

        return positionMatrix;
    }
}

