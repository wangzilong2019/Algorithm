package leetcode.algorithm.dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Exists {

    /**
     深度优先搜索：
     遍历机身字符，以每一个点作为起点
     当遍历出边界或当前字符和字符串指定位置字符不同时返回false
     当遍历到字符串最后一个位置返回true
     否在递归遍历

     */

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if(k == word.length - 1) return true;
        char tmp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        board[i][j] = tmp;
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 5};

    }
}
