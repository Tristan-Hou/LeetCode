package com.leetcode;

public class Q190 {
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++) {
            int tmp = (1 << i) & n;
            if(i < 16) {
                res |= tmp << (15 - i + 16 - i);
            } else {
                res |= tmp >>> (i - 15 + i - 16);
            }
        }
        return res;
    }
}
