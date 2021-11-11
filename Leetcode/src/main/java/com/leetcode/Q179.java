package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

class Q179 {
    public String largestNumber(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                int high1 = getHightLevel(o1);
                int high2 = getHightLevel(o2);
                if(high1 != high2) {
                    return -high1 + high2;
                }
                int x1 = 10;
                int x2 = 10;
                while(o1 >= x1) {
                    x1 *= 10;
                }
                while(o2 >= x2) {
                    x2 *=10;
                }
                int res1 = o2 != 0 ? o1 * x2 + o2 : o1;
                int res2 = o1 != 0 ? o2 * x1 + o1 : o2;
                return -res1 + res2;
            }
        });

        for(int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        int k = 0;
        while (k < sb.length() - 1 && sb.charAt(k) == '0') {
            k++;
        }
        return sb.toString();

    }

    public int getHightLevel(int num) {
        while(num >= 10) {
            num = num / 10;
        }
        return num;
    }
}
