package com.leetcode;

class code12 {
    int[][] help = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0) {
            return true;
        }
        int row = board.length;
        int column = board[0].length;
        boolean[][] tags = new boolean[row][column];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                if(board[i][j] == word.charAt(0)) {
                    boolean res = dfs(board, i, j, word, 0, tags);
                    if(!res) {
                        clearTags(tags, row, column);
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] tags) {
        if(i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || tags[i][j]) {
            return false;
        }
        if(board[i][j] == word.charAt(index)) {
            tags[i][j] = true;
            if(index == word.length() - 1) {
                return true;
            } else {
                for(int k = 0; k < 4; k++) {
                    boolean deep = dfs(board, i + help[k][0], j + help[k][1], word, index + 1, tags);
                    if(deep) {
                        return true;
                    }
                }
            }
        }
        tags[i][j] = false;
        return false;
    }

    private void clearTags(boolean[][] tags, int row, int column) {
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                tags[i][j] = false;
            }
        }
    }
}
