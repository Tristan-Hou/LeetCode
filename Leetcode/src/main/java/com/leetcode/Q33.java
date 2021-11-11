package com.leetcode;

public class Q33 {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left) / 2;

        while (left <= right) {
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {  //左边升序
                if (target >= nums[left] && target <= nums[mid]) {//在左边范围内
                    right = mid - 1;
                } else {//只能从右边找
                    left = mid + 1;
                }

            } else { //右边升序
                if (target >= nums[mid] && target <= nums[right]) {//在右边范围内
                    left = mid + 1;
                } else {//只能从左边找
                    right = mid - 1;
                }

            }
            mid = left + (right - left) / 2;
        }

        return -1;  //没找到
    }

    /*public int search(int[] nums, int target) {
        int size = nums.length;
        if(size <= 0) {
            return -1;
        }
        if(size == 1) {
            if(nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        int left = 0;
        int right = size - 1;
        return search(nums, target, left, right);
    }

    private int search(int[] nums, int target, int left, int right) {
        int mid = left + ((right - left) >> 1);
        int pos = -1;
        if(target == nums[left]) {
            pos = left;
        } else if(target == nums[right]) {
            pos = right;
        } else if(target > nums[left]) {
            if(target < nums[mid]) {
                pos = search2(nums, target, left, mid - 1);
            } else if(target > nums[mid]) {
                if (nums[mid] >= nums[left]) {
                    pos = search(nums, target, mid + 1, right);
                } else {
                    pos = search(nums, target, left, mid - 1);
                }
            } else {
                pos = mid;
            }
        } else if(target < nums[right]) {
            if(target > nums[mid]) {
                pos = search2(nums, target, mid + 1, right);
            } else if(target < nums[mid]) {
                if (nums[mid] <= nums[right]) {
                    pos = search2(nums, target, left, mid - 1);
                } else {
                    pos = search(nums, target, mid + 1, right);
                }
            } else {
                pos = mid;
            }
        }
        return pos;
    }

    private int search2(int[] nums, int target, int left, int right) {
        int pos = -1;
        while(left <= right) {
            int mid = left + ((right - left) >> 1);
            if(target < nums[mid]) {
                right = mid - 1;
            } else if(target > nums[mid]) {
                left = mid + 1;
            } else {
                pos = mid;
                break;
            }
        }
        return pos;
    }*/
}
