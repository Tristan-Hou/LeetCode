package com.leetcode;

/**
 * 面试题40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 */
public class M40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        int len = arr.length;
        if(len <= k) {
            return arr;
        }
        sort(arr, 0, len-1);

        int[] result = new int[k];
        for(int i=0; i<k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    private void sort(int[] arr, int left, int right) {
        if(left >= right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        sort(arr, left, mid);
        sort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int l = left;
        int r = mid + 1;
        int k=0;
        while(l <= mid && r <= right) {
            if(arr[l] < arr[r]) {
                tmp[k++] = arr[l++];
            } else {
                tmp[k++] = arr[r++];
            }
        }
        while(l <= mid) {
            tmp[k++] = arr[l++];
        }
        while(r <= right) {
            tmp[k++] = arr[r++];
        }
        for(int i=0; i<k; i++) {
            arr[i+left] = tmp[i];
        }
    }
}
