package com.leetcode;

/**
 * https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
 */
public class Q304 {

    private int[][] matrix;

    public Q304(int[][] matrix) {
        this.matrix = matrix;
        int row = matrix.length;
        int column = matrix[0].length;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                if(j > 0) {
                    matrix[i][j] = matrix[i][j - 1] + matrix[i][j];
                }
            }
        }
        for(int j = column - 1; j >= 0; j--) {
            for(int i = 0; i < row; i++) {
                if(i > 0) {
                    matrix[i][j] = matrix[i - 1][j] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1 == 0 && col1 == 0) {
            return matrix[row2][col2];
        } else if(row1 == 0 && col1 != 0) {
            return matrix[row2][col2] - matrix[row2][col1 - 1];
        } else if(row1 != 0 && col1 == 0) {
            return matrix[row2][col2] - matrix[row1 - 1][col2];
        } else {
            return matrix[row2][col2] - matrix[row2][col1 - 1] - matrix[row1 - 1][col2] + matrix[row1 - 1][col1 - 1];
        }
    }

}
