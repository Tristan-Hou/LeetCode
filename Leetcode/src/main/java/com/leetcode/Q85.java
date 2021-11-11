package com.leetcode;

import java.util.Arrays;
import java.util.Stack;

class Q85 {
    public int maximalRectangle(char[][] mMatrix) {
        int m = mMatrix.length;
        if(m == 0) {
            return 0;
        }
        int n = mMatrix[0].length;

        int[][] matrix = new int[m][n];
        for(int j = 0; j < n; j++) {
            for(int i = 0; i < m; i++) {
                if(mMatrix[i][j] == '1') {
                    if(i == 0) {
                        matrix[i][j] = 1;
                    } else {
                        matrix[i][j] = matrix[i - 1][j] + 1;
                    }
                }
            }
        }

        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < m; i++) {
            int[] left = new int[n];
            int[] right = new int[n];
            Arrays.fill(left, -1);
            Arrays.fill(right, n);
            for(int j = 0; j < n; j++) {
                while(!stack.isEmpty() && matrix[i][stack.peek()] >= matrix[i][j]) {
                    stack.pop();
                }
                if(!stack.isEmpty()) {
                    left[j] = stack.peek();
                }
                stack.push(j);
            }
            stack.clear();

            for(int j = n - 1; j >= 0; j--) {
                while(!stack.isEmpty() && matrix[i][stack.peek()] >= matrix[i][j]) {
                    stack.pop();
                }
                if(!stack.isEmpty()) {
                    right[j] = stack.peek();
                }
                stack.push(j);
            }
            stack.clear();

            for(int j = 0; j < n; j++) {
                int curWidth = right[j] - left[j] - 1;
                int curHeight = matrix[i][j];
                ans = Math.max(ans, curWidth * curHeight);
            }

        }
        return ans;
    }
}
