package com.leetcode;

public class Q74 {
    int column;

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        column = n - 1;
        return dfs(matrix, target, 0, m - 1, 0, n - 1);
    }

    private boolean dfs(int[][] matrix, int target, int row0, int row1, int column0, int column1) {
        if(column0 > column1 || row0 > row1 || target < matrix[row0][column0] || target > matrix[row1][column1]) {
            return false;
        }
        int rowMid = ((row1 - row0) >> 1) + row0;
        int columnMid = ((column1 - column0) >> 1) + column0;
        int tmp = matrix[rowMid][columnMid];
        if(tmp == target) {
            return true;
        } else if(tmp > target) {
            return dfs(matrix, target, row0, rowMid, column0, columnMid);
        } else {
            boolean find = binarySearch(matrix, target, rowMid, columnMid + 1, column);
            if(find) {
                return true;
            } else {
                return dfs(matrix, target, rowMid + 1, row1, column0, column1);
            }
        }
    }

    private boolean binarySearch(int[][] matrix, int target, int row, int column0, int column1) {
        if(column0 > column1 || target < matrix[row][column0] || target > matrix[row][column1]) {
            return false;
        }
        int columnMid = ((column1 - column0) >> 1) + column0;
        if(matrix[row][columnMid] == target) {
            return true;
        } else if(matrix[row][columnMid] < target) {
            return binarySearch(matrix, target, row, columnMid + 1, column1);
        } else {
            return binarySearch(matrix, target, row, column0, columnMid - 1);
        }
    }
}
