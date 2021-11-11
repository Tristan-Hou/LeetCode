package com.leetcode;

public class Test {

    /**
     *
     * 0 0 0 0 0 0 0 0
     * 0 1 0 0 0 0 0 0
     * 0 0 1 1 0 0 0 0
     * 0 0 0 0 1 0 0 0
     * 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0
     *
     *
     *
     * @param input
     * @return
     */
    int[] x = new int[]{-1,0,1};
    int[] y = new int[]{-1,0,1};
    public int[][] test(int[][] input) {
        int row = input.length;
        int column = input[0].length;
        for (int i=0; i<row; i++) {
            for (int j=0; j<column; j++) {
                input[i][j] = test(input, i,j, row, column);
            }
        }
        for (int i=0; i<row; i++) {
            for (int j=0; j<column; j++) {
                input[i][j] = (input[i][j]>>1 );
            }
        }
        return input;
    }

    private int test(int[][] input, int i, int j, int row, int column) {
        int count = 0;
        for(int m=0; m<3; m++) {
            for (int n=0; n<3; n++) {
                if (x[m] == 0 && y[n]==0) {
                    continue;
                }

                if(i+x[m]<0 || j+y[n]<0 || i+x[m] > row-1 || j+y[n] > column-1) {
                    continue;
                } else if ((input[i+x[m]][j+y[n]] &1) == 1){
                    count++;
                }
            }
        }
        if (input[i][j] == 0) {
            if (count == 3) {
                input[i][j] |= 2;
            }
        } else {
            if (count ==2 || count == 3) {
                input[i][j] |= 2;
            }
        }
        return input[i][j];
    }



}
