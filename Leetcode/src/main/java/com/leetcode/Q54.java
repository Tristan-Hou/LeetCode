package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q54 {

    private int[] res;
    private int pos = 0;
    private int total = 0;
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        total = m * n;
        res = new int[total];
        int start = 0;
        int left = 0;
        int end = m - 1;
        int right = n - 1;
        while((start <= end || left <= right) && pos != total) {
            circle(matrix, start, end, left, right);
            if(start + 1 < end) {
                start++;
                end--;
            }
            if(left + 1 < right) {
                left++;
                right--;
            }
        }

        // int len = res.length;
        List<Integer> list = new ArrayList<>();
        for(int i : res) {
            list.add(new Integer(i));
        }
        return list;
    }

    public void circle(int[][] matrix, int rowStart, int rowEnd, int columnStart, int columnEnd) {
        int index = columnStart;
        while(index <= columnEnd && pos != total) {
            res[pos] = matrix[rowStart][index];
            pos++;
            if(index == columnEnd) {
                break;
            }
            index++;
        }
        int index1 = rowStart + 1;
        while(index1 <= rowEnd && pos != total) {
            res[pos] = matrix[index1][columnEnd];
            pos++;
            if(index1 == rowEnd) {
                break;
            }
            index1++;
        }
        index--;
        while(index >= columnStart && pos != total) {
            res[pos] = matrix[rowEnd][index];
            pos++;
            if(index == columnStart) {
                break;
            }
            index--;
        }
        index1--;
        while(index1 > rowStart && pos != total) {
            res[pos] = matrix[index1][columnStart];
            pos++;
            if(index1 == rowStart + 1) {
                break;
            }
            index1--;
        }
    }
}
