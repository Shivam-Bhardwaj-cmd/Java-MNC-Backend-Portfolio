package day33;

import java.util.*;

public class WordSearchII {
    static int ROWS, COLS;

    public static void main(String[] args) {
        char[][] board = {
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','k','r'},
            {'i','f','l','v'}
        };
        String[] words = {"oath","pea","eat","rain"};

        List<String> foundWords = findWords(board, words);
        System.out.println("Words found: " + foundWords);
    }

    static List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        ROWS = board.length;
        COLS = board[0].length;

        for (String word : words) {
            boolean found = false;
            for (int i = 0; i < ROWS && !found; i++) {
                for (int j = 0; j < COLS && !found; j++) {
                    if (exist(board, word, i, j, 0)) {
                        result.add(word);
                        found = true;
                    }
                }
            }
        }
        return result;
    }

    static boolean exist(char[][] board, String word, int row, int col, int index) {
        if (index == word.length()) return true;
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS || board[row][col] != word.charAt(index)) return false;

        char temp = board[row][col];
        board[row][col] = '#'; // mark visited
        boolean found = exist(board, word, row + 1, col, index + 1) ||
                        exist(board, word, row - 1, col, index + 1) ||
                        exist(board, word, row, col + 1, index + 1) ||
                        exist(board, word, row, col - 1, index + 1);
        board[row][col] = temp; // unmark
        return found;
    }
}
