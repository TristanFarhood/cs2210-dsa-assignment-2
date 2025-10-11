public class Vertical2DIteration {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Vertical iteration (column by column)
        System.out.println("Iterating vertically:");
        for (int col = 0; col < matrix[0].length; col++) { // Outer loop iterates through columns
            for (int row = 0; row < matrix.length; row++) { // Inner loop iterates through rows
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println(); // Move to the next line after each column
        }
    }
}