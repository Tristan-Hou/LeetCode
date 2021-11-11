package com.leetcode;

public class Q300 {

    public int lengthOfLIS(int[] nums) {
        int size = nums.length;
        if(size <= 0) {
            return 0;
        }
        if(size == 1) {
            return 1;
        }
        int[] result = new int[size];
        result[0] = 1;
        int max = 1;
        for(int i=1; i<size; i++) {
            int tmp = 0;
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j]) {
                    tmp = Math.max(tmp, result[j]);
                }
            }
            result[i] = tmp + 1;
            max = Math.max(max, result[i]);
        }
        return max;
    }
}
