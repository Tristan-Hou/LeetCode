package com.leetcode;

/**
 * 695. 岛屿的最大面积
 * <p>
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 * <p>
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 * <p>
 * 示例 1:
 * <p>
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
 * <p>
 * 示例 2:
 * <p>
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 * <p>
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 */
public class Q695 {
    int column;
    int row;
    public int maxAreaOfIsland(int[][] grid) {
        column = grid.length;
        if(column <= 0) {
            return 0;
        }
        row = grid[0].length;
        int max = 0;
        for(int i=0; i<column; i++) {
            for(int j=0; j<row; j++) {
                if(grid[i][j] != 1) {
                    continue;
                }
                max = Math.max(max, getArea(grid, i, j));
            }
        }
        return max;
    }

    private int getArea(int[][] grid, int i, int j) {
        if (i >= column || j >= row || i < 0 || j < 0) {
            return 0;
        }
        int result = 0;
        if (grid[i][j] == 1) {
            grid[i][j] = -1;
            result = getArea(grid, i + 1, j)
                    + getArea(grid, i, j + 1)
                    + getArea(grid, i - 1, j)
                    + getArea(grid, i, j - 1)
                    + 1;
        }
        return result;
    }
}
