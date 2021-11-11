package com.leetcode;

import java.util.LinkedList;

class Q224 {

    public int calculate(String s) {
        LinkedList<Integer> stackNum = new LinkedList<>();
        LinkedList<Integer> stackSign = new LinkedList<>();
        int length = s.length();
        int ans = 0;
        int sigh = 1;
        for(int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if(c == ' ') {
                continue;
            } else if(c == '+') {
                sigh = 1;
            } else if(c == '-') {
                sigh = -1;
            } else if(c >= '0' && c <= '9') {
                int num = c - '0';
                while(i + 1 < length && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    num = 10 * num + (s.charAt(i + 1) - '0');
                    i++;
                }
                ans = ans + sigh * num;
            } else if(c == '(') {
                stackNum.push(ans);
                stackSign.push(sigh);
                ans = 0;
                sigh = 1;
            } else if(c == ')') {
                ans = stackNum.pop() + stackSign.pop() * ans;
            }
        }
        return ans;
    }
}
