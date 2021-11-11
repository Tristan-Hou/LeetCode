package com.leetcode;

/**
 * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
 *
 * 示例1:
 *
 *  输入：nums = [0, 2, 3, 4, 5]
 *  输出：0
 *  说明: 0下标的元素为0
 * 示例2:
 *
 *  输入：nums = [1, 1, 1]
 *  输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/magic-index-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q0803 {
    public int findMagicIndex(int[] nums) {
        return getAnswer(nums, 0, nums.length - 1);
    }

    public int getAnswer(int[] nums, int left, int right) {
        int res = -1;
        if(left > right) {
            return res;
        }
        int mid = ((right - left) >> 1) + left;
        if(mid == nums[mid]) {
            res = mid;
            int tmp = getAnswer(nums, left, mid-1);
            if(tmp != -1) {
                res = tmp;
                return res;
            }
        } else {
            int tmp = getAnswer(nums, left, mid-1);
            if(tmp != -1) {
                res = tmp;
                return res;
            } else {
                int tmp1 = getAnswer(nums, mid+1, right);
                if(tmp1 != -1) {
                    res = tmp1;
                    return res;
                }
            }
        }
        return res;
    }



    // public int findMagicIndex(int[] nums) {
    //     return getAnswer(nums, 0, nums.length - 1);
    // }

    // public int getAnswer(int[] nums, int left, int right) {
    //     if (left > right) {
    //         return -1;
    //     }
    //     int mid = (right - left) / 2 + left;
    //     int leftAnswer = getAnswer(nums, left, mid - 1);
    //     if (leftAnswer != -1) {
    //         return leftAnswer;
    //     } else if (nums[mid] == mid) {
    //         return mid;
    //     }
    //     return getAnswer(nums, mid + 1, right);
    // }
}
