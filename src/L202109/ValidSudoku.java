package L202109;
/*2021.09.17
Determine if a 9 x 9 Sudoku board is valid.
Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.*/

import java.util.ArrayList;
import java.util.Arrays;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board =  
{{'7','.','.','.','4','.','.','.','.'},{'.','.','.','8','6','5','.','.','.'},{'.','1','.','2','.','.','.','.','.'},{'.','.','.','.','.','9','.','.','.'},{'.','.','.','.','5','.','5','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','2','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'}};
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        boolean[] isVisitRow = new boolean[9];
        boolean[] isVisitColumn = new boolean[9];
        setFalse(isVisitRow);
        setFalse(isVisitColumn);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int indexRow = board[i][j] - 48;
                int indexColumn = board[j][i] - 48;
                if (indexRow > 0){
                    if (isVisitRow[indexRow - 1]) {
                        return false;
                    }
                    isVisitRow[indexRow - 1] = true;
                }
                if (indexColumn > 0){
                    if (isVisitColumn[indexColumn - 1]) {
                        return false;
                    }
                    isVisitColumn[indexColumn - 1] = true;
                }
            }
            setFalse(isVisitRow);
            setFalse(isVisitColumn);
        }

        boolean[] isVisitInSubBoxes = new boolean[9];
        setFalse(isVisitInSubBoxes);
        for (int row = 0; row < 9; row=row+3){
            for (int column = 0; column < 9; column=column+3){
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int index = board[row + i][column + j] - 48;
                        if (index > 0){
                            if (isVisitInSubBoxes[index - 1]) {
                                return false;
                            }
                            isVisitInSubBoxes[index - 1] = true;
                        }
                    }
                }
                setFalse(isVisitInSubBoxes);
            }
        }
        return true;
    }

    public static void setFalse(boolean[] isVisitInSubBoxes){
        for (int i = 0; i < 9; i++) {
            isVisitInSubBoxes[i] = false;
        }
    }
}
