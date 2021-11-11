package com.leetcode;

import java.util.LinkedList;

public class Q1006 {
    public int clumsy(int N) {
        LinkedList<Integer> stack = new LinkedList<>();
        int n = N;
        int[] flag = new int[]{0, 1, 2, 3};
        //String[] flagStr = new String[4] {"*", "/", "-", "+"};

        stack.push(n--);
        while(n > 0) {
            int m = (N - n - 1) % 4;
            switch(m) {
                case 0:
                    int tmp = stack.pop();
                    tmp *= n;
                    stack.push(tmp);
                    break;
                case 1:
                    int tmp1 = stack.pop();
                    tmp1 /= n;
                    stack.push(tmp1);
                    break;
                case 2:
                    stack.push(n);
                    break;
                case 3:
                    stack.push(-n);
                    break;
            }
            n--;
        };
        int ans = 0;
        while(!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
