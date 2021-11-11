package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q200 {

    public int numIslands(char[][] grid) {
        int colomn = grid.length;
        int row = grid[0].length;
        int total = 0;
        for(int i=0; i<colomn; i++) {
            for(int j=0; j<row; j++) {
                if(markIsland(grid, i, j)) {
                    total++;
                }
            }
        }
        return total;
    }

    public boolean markIsland(char[][] grid, int i, int j) {
        if(grid[i][j] != '1') {
            return false;
        }
        grid[i][j] -= 1;
        int[] x = new int[]{1, 0, -1, 0};
        int[] y = new int[]{0, 1, 0, -1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        while(!queue.isEmpty()) {
            int[] pos = queue.poll();
            for(int m=0; m<4; m++) {
                if(pos[0]+x[m] >=0 && pos[0]+x[m] < grid.length
                        && pos[1]+y[m] >=0 && pos[1]+y[m] < grid[0].length
                        && grid[pos[0]+x[m]][pos[1]+y[m]] == '1') {
                    grid[pos[0]+x[m]][pos[1]+y[m]] -= 1;
                    queue.offer(new int[]{pos[0]+x[m], pos[1]+y[m]});
                }
            }
        }
        return true;
    }

}
