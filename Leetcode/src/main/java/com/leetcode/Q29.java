package com.leetcode;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 *
 * 限制：
 *
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q29 {
    public int[] spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int i = 0;
        int j = 0;
        int count = 0;
        int[] res = new int[row * column];
        int[][] state = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int[] bound = new int[]{0, 0, column-1, row-1};
        int pos = 0;
        while(count != row*column) {
            res[count++] = matrix[i][j];
            if(i + state[pos][0] > bound[3]) {
                pos = pos >= 3 ? 0 : ++pos;
                bound[2]--;
            } else if(i + state[pos][0] < bound[1]) {
                pos = pos >= 3 ? 0 : ++pos;
                bound[0]++;
            } else if(j + state[pos][1] > bound[2]) {
                pos = pos >= 3 ? 0 : ++pos;
                bound[1]++;
            } else if(j + state[pos][1] < bound[0]) {
                pos = pos >= 3 ? 0 : ++pos;
                bound[3]--;
            }
            i = i + state[pos][0];
            j = j + state[pos][1];
        }
        return res;
    }
}
