package day31;

public class WordSearchDemo {
    static int ROWS, COLS;

    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED";

        System.out.println("Word " + word + " exists: " + exist(board, word));
    }

    static boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (backtrack(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    static boolean backtrack(char[][] board, int row, int col, String word, int index) {
        if (index == word.length()) return true;
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS || board[row][col] != word.charAt(index)) return false;

        char temp = board[row][col];
        board[row][col] = '#'; // mark visited
        boolean found = backtrack(board, row + 1, col, word, index + 1) ||
                        backtrack(board, row - 1, col, word, index + 1) ||
                        backtrack(board, row, col + 1, word, index + 1) ||
                        backtrack(board, row, col - 1, word, index + 1);
        board[row][col] = temp; // unmark
        return found;
    }
}
