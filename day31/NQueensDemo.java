package day31;

import java.util.*;

public class NQueensDemo {
    public static void main(String[] args) {
        int n = 4;
        solveNQueens(n);
    }

    static void solveNQueens(int n) {
        int[] board = new int[n]; // board[i] = column of queen in row i
        placeQueens(0, board, n);
    }

    static void placeQueens(int row, int[] board, int n) {
        if (row == n) {
            printBoard(board, n);
            System.out.println();
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, board)) {
                board[row] = col;
                placeQueens(row + 1, board, n);
            }
        }
    }

    static boolean isSafe(int row, int col, int[] board) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(row - i) == Math.abs(col - board[i])) return false;
        }
        return true;
    }

    static void printBoard(int[] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i] == j ? "Q " : ". ");
            }
            System.out.println();
        }
    }
}
