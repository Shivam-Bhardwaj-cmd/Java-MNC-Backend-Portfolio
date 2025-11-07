package day33;

import java.util.*;

public class NQueensII {

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> solutions = solveNQueens(n);
        System.out.println("All possible solutions for " + n + "-Queens:");
        for (List<String> sol : solutions) {
            for (String row : sol) System.out.println(row);
            System.out.println();
        }
    }

    static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] board = new int[n];
        placeQueens(0, board, n, result);
        return result;
    }

    static void placeQueens(int row, int[] board, int n, List<List<String>> result) {
        if (row == n) {
            result.add(buildBoard(board, n));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, board)) {
                board[row] = col;
                placeQueens(row + 1, board, n, result);
            }
        }
    }

    static boolean isSafe(int row, int col, int[] board) {
        for (int i = 0; i < row; i++)
            if (board[i] == col || Math.abs(row - i) == Math.abs(col - board[i])) return false;
        return true;
    }

    static List<String> buildBoard(int[] board, int n) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[board[i]] = 'Q';
            res.add(new String(row));
        }
        return res;
    }
}
