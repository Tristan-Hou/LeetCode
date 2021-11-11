package com.leetcode;

public class Q7 {
    public int reverse(int x) {
        int res = 0;
         do {
            int tmp = x % 10;
            res = res * 10 + tmp;
            x = x / 10;
        } while(x != 0);
        if(res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        }
        return res;
    }
}
