package com.leetcode;

/*
在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。

示例:

输入:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

输出: 4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximal-square
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q221 {

    public int maximalSquare(char[][] matrixChar) {
        if(matrixChar == null) {
            return 0;
        }
        int column = matrixChar.length;
        if(column == 0) {
            return 0;
        }
        int row = matrixChar[0].length;
        int[][] matrix = new int[column][row];
        int maxValue = 0;
        for(int i=0; i<column; i++) {
            for(int j=0; j<row; j++) {
                matrix[i][j] = matrixChar[i][j] - '0';
                if (matrix[i][j] == 1) {
                    maxValue = matrix[i][j];
                }
            }
        }
        for(int i=0; i<column; i++) {
            for(int j=0; j<row; j++) {
                if (matrix[i][j] != 0 && i - 1 >= 0 && j - 1 >= 0) {
                    int value = matrix[i-1][j-1];
                    if(value != 0) {
                        boolean flag = true;
                        for(int m=i-1; m>=i-value; m--) {
                            if(matrix[m][j] == 0) {
                                flag = false;
                                continue;
                            }
                        }
                        for(int n=j-1; n>=j-value; n--) {
                            if(matrix[i][n] == 0) {
                                flag = false;
                                continue;
                            }
                        }
                        if(flag) {
                            matrix[i][j] = ++value;
                        }
                    }
                    maxValue = Math.max(maxValue, matrix[i][j]);
                }
            }
        }
        return maxValue * maxValue;
    }

}
