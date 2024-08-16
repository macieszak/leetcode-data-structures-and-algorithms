package arrays_and_hashing.valid_sudoku;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {

        //checking rows
        Set<Character> rows = new HashSet<>();
        Set<Character> columns = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                //checking rows
                if (Character.isDigit(board[i][j]) && rows.contains(board[i][j])) {
                    return false;
                }
                if (Character.isDigit(board[i][j])) {
                    rows.add(board[i][j]);
                }

                //checking columns
                if (Character.isDigit(board[j][i]) && columns.contains(board[j][i])) {
                    return false;
                }
                if (Character.isDigit(board[j][i])) {
                    columns.add(board[j][i]);
                }

            }
            rows.clear();
            columns.clear();
        }

        //checking 9x9 squares
        int rowMin = 0;
        int rowMax = 2;
        int colMin = 0;
        int colMax = 2;
        Set<Character> squares = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = rowMin; k <= rowMax; k++) {
                    for (int l = colMin; l <= colMax; l++) {
                        if (Character.isDigit(board[k][l]) && squares.contains(board[k][l])) {
                            return false;
                        }
                        if (Character.isDigit(board[k][l])) {
                            squares.add(board[k][l]);
                        }
                    }
                }
                colMin += 3;
                colMax += 3;
                squares.clear();
            }
            rowMin += 3;
            rowMax += 3;
            colMin = 0;
            colMax = 2;
        }


        return true;
    }


    public static boolean isValidSudokuMoreOptimal(char[][] board) {
        Set seen = new HashSet();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i / 3 + "-" + j / 3))
                        return false;
            }
        }
        return true;
    }

}
