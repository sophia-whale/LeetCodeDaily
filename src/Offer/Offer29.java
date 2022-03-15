package Offer;

public class Offer29 {
    public int[] spiralOrder(int[][] matrix) {
        int length = matrix.length * matrix[0].length;
        if (length == 0) return new int[0];
        int[] nums = new int[length];
        int row = 0;
        int col = 0;
        int rowL = matrix.length - 1;
        int colL = matrix[0].length - 1;
        int cur = 0;
        while (true) {
            for (int i = col; i <= colL; i++) {
                nums[cur] = matrix[row][i];
                cur++;
            }
            row++;
            if (row > rowL) {
                break;
            }

            for (int i = row; i <= rowL; i++) {
                nums[cur] = matrix[i][colL];
                cur++;
            }
            colL--;
            if (colL < col) {
                break;
            }

            for (int i = colL; i >= col; i--) {
                nums[cur] = matrix[rowL][i];
                cur++;
            }
            rowL--;
            if (rowL < row) {
                break;
            }

            for (int i = rowL; i >= row; i--) {
                nums[cur] = matrix[i][col];
            }
            col++;
            if (col > colL) {
                break;
            }
        }
        return nums;
    }
}
