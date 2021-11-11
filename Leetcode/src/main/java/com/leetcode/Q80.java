package com.leetcode;

public class Q80 {

    public int removeDuplicates(int[] nums) {
        int size = nums.length;
        if(size < 2) {
            return size;
        }
        int i = 0, j = 0;
        while(j < size) {
            if(i - 2 >= 0) {
                if(nums[i - 2] == nums[i] || nums[i] < nums[i - 2]) {
                    if(nums[i - 2] == nums[j]) {
                        j++;
                        continue;
                    }
                    nums[i] = nums[j];
                }
            }
            i++;
            j++;
        }
        return i;
    }
}
