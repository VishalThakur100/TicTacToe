import java.util.ArrayList;

import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = '.';
            }
        }
        return printNQueens(board, 0);
    }

    public static List<List<String>> printNQueens(char[][] board, int row) {
        if (row == board.length) {
           return List.of(printBoard(board));
        }
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 'Q';
                result.addAll(printNQueens(board, row + 1));
                board[row][i] = '.';
            }
        }
        return result;
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        //  top
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        //  left diagonal
        for (int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        //   right diagonal
        for (int i = row-1, j = col+1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static List<String> printBoard(char[][] board) {

        List<String> ans=new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < board[0].length; j++) {
               temp.append(board[i][j]);
            }
            ans.add(temp.toString());
        }
        return ans;
    }
}
