package com.leetcode;

class Q81 {
    public boolean search(int[] nums, int target) {
        int length = nums.length;
        int flag = -1;
        if(length == 1) {
            flag = 0;
        }
        for(int i = 1; i < length; i++) {
            if(nums[i] < nums[i - 1]) {
                flag = i - 1;
                break;
            }
        }

        int left = 0;
        int right = length - 1;
        while(left <= right) {
            int mid = ((right - left) >> 1) + left;
            if(nums[mid] == target) {
                return true;
            } else if(target < nums[mid]) {
                if(mid <= flag) {
                    right = mid - 1;
                } else{
                    left = flag + 1;
                    right = mid - 1;
                }
            } else {
                if(mid > flag) {
                    left = mid + 1;
                } else {
                    left = mid + 1;
                    right = flag;
                }
            }
        }
        return false;
    }
}
