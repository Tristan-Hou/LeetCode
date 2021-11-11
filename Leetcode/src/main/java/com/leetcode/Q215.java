package com.leetcode;

class Q215 {

    public int findKthLargest(int[] nums, int k) {
        int size = nums.length;
        for(int i = size / 2 - 1; i >= 0; i--) {
            buildHeap(nums, i, size);
        }
        for(int i = 0; i < k - 1; i++) {
            int tmp = nums[size - 1 - i];
            nums[size - 1 - i] = nums[0];
            nums[0] = tmp;

            buildHeap(nums, 0, size - 1 - i - 1);
        }
        return nums[0];
    }

    private void buildHeap(int[] nums, int begin, int tail) {
        int top = nums[begin];
        int index = begin;
        int child = index * 2 + 1;
        while(child < tail) {
            if(child + 1 < tail && nums[child] < nums[child + 1]) {
                child = child + 1;
            }
            if(top < nums[child]) {
                nums[index] = nums[child];
                index = child;
                child = index * 2 + 1;
            } else {
                break;
            }
        }
        nums[index] = top;
    }
}
