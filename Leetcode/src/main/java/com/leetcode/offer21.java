package com.leetcode;

class offer21 {
    public int[] exchange(int[] nums) {
        int size = nums.length;
        if(size == 0) {
            return nums;
        }
        int left = 0, right = size - 1;
        int tmp = nums[0];
        while(left < right) {
            while(left != right && (nums[right] & 1) == 0) {
                right--;
            }
            nums[left] = nums[right];
            while(left != right && (nums[left] & 1) == 1) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = tmp;
        return nums;
    }
}
