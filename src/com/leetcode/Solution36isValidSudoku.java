package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution36isValidSudoku {
    boolean ans = false;
    Set<Character> rowSet;
    Set<Character> colSet;
    Set<Character> mixSet;

    public boolean isValidSudoku(char[][] board) {
        mixSet = new HashSet<>();
        for (int row = 0; row < board.length; row++) {
            rowSet = new HashSet<>();
            for (int col = 0; col < board.length; col++) {
                colSet = new HashSet<>();
                char point = board[row][col];
                if (point == '.') {
                    continue;
                } else {
                    if (rowSet.contains(point) || colSet.contains(point) ) {
                        ans = false;
                    } else {
                        rowSet.add(point);
                        colSet.add(point);
                    }
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] board, int row) {
        if (row >= board.length) {
            return;
        }
        for (int col = 0; col < board.length; col++) {
            char i = board[row][col];
            if (i != '.') {
                if (rowSet.contains(i) || colSet.contains(i) || mixSet.contains(i)) {

                }
            }
        }
    }
}
