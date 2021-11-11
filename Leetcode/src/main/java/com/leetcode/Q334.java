package com.leetcode;

class Q334 {
    public boolean increasingTriplet(int[] nums) {
        int max = Integer.MIN_VALUE;
        int mid = Integer.MIN_VALUE;
        int length = nums.length;
        for(int i = length - 1; i >= 0; i--) {
            if(nums[i] > max) {
                max = nums[i];
            } else if(nums[i] < max && nums[i] > mid) {
                mid = nums[i];
            } else if(nums[i] < mid) {
                return true;
            }
        }
        return false;
    }
}
