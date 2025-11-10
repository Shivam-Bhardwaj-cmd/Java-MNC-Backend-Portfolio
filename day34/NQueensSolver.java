package com.dsa.recursion;

public class NQueensSolver {

    static int N = 4;

    public static void main(String[] args) {
        boolean[][] board = new boolean[N][N];
        System.out.println("All possible solutions for " + N + "-Queens:");
        solve(board, 0);
    }

    static void solve(boolean[][] board, int row) {
        if (row == board.length) {
            printBoard(board);
            System.out.println();
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                solve(board, row + 1);
                board[row][col] = false; // backtrack
            }
        }
    }

    static boolean isSafe(boolean[][] board, int row, int col) {
        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col]) return false;
        }

        // Check left diagonal
        for (int i = 1; i <= Math.min(row, col); i++) {
            if (board[row - i][col - i]) return false;
        }

        // Check right diagonal
        for (int i = 1; i <= Math.min(row, board.length - col - 1); i++) {
            if (board[row - i][col + i]) return false;
        }

        return true;
    }

    static void printBoard(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean cell : row) {
                System.out.print(cell ? "Q " : ". ");
            }
            System.out.println();
        }
    }
}
