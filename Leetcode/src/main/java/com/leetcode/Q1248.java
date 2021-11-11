package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums 和一个整数 k。
 *
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 *
 * 请返回这个数组中「优美子数组」的数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * 示例 2：
 *
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 * 示例 3：
 *
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-number-of-nice-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q1248 {

    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> posList = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            if((nums[i] & 1) == 1) {
                posList.add(i);
            }
        }
        if(posList.size() < k) {
            return 0;
        }
        int total = 0;
        for(int i=0,j=i+k-1; j<posList.size(); i++, j++) {
            int before = 0;
            int after = nums.length - 1;
            if(i>0) {
                before = posList.get(i-1);
            }
            if(j<posList.size() - 1) {
                after = posList.get(j+1)+1;
            }
            int start = posList.get(i);
            int end = posList.get(j);

            int left = start - before;
            int right = after - end;

            total += (left - right > 0 ? calculate(right, left) : calculate(left, right));
        }
        return total;
    }

    private int calculate(int small, int large) {
        // if(small < 0) {
        //     small = 0;
        // }
        // if(large < 0) {
        //     large = 0;
        // }

        large += 1;
        small += 1;
        int minus = large - small;

        return (1 + large) * large / 2 - (1 + minus) * minus / 2 ;
    }
}
