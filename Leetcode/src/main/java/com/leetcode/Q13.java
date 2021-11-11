package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 1：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q13 {

    public int movingCount(int m, int n, int k) {
        Deque<int[]> q = new LinkedList<>();
        boolean[][] visited=new boolean[m][n];
        int[] x = new int[]{0, 1, 0, -1};
        int[] y = new int[]{-1, 0, 1, 0};
        q.push(new int[]{0, 0});
        visited[0][0] = true;
        int count = 0;
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            count++;
            for(int i=0; i<x.length; i++) {
                if(curr[0]+x[i]>=0 && curr[0]+x[i]<m && curr[1]+y[i]>=0 && curr[1]+y[i]<n
                        && !visited[curr[0]+x[i]][curr[1]+y[i]]) {
                    visited[curr[0]+x[i]][curr[1]+y[i]] = true;
                    if(sums(curr[0]+x[i], curr[1]+y[i]) <= k) {
                        q.push(new int[]{curr[0]+x[i], curr[1]+y[i]});
                    }
                }
            }
        }
        return count;
    }
    public int sums(int x,int y){
        int ans=0;
        while (x != 0) {
            ans+=x%10;
            x/=10;
        }
        while (y != 0) {
            ans+=y%10;
            y/=10;
        }
        return ans;
    }
}
