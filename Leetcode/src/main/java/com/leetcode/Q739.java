package com.leetcode;

import java.util.Stack;

/**
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q739 {
    public int[] dailyTemperatures(int[] T) {
        int size = T.length;
        if(size == 0) {
            return new int[0];
        }
        if(size == 1) {
            return new int[]{0};
        }
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[size];
        for(int i=0; i<size-1; i++) {
            int j = i+1;
            if(j==size-1) {
                res[size-1] = 0;
            }
            if(T[i] < T[j]) {
                res[i] = 1;
                while(!stack.isEmpty() && T[stack.peek()] < T[j]) {
                    int pos = stack.pop();
                    res[pos] = j-pos;
                }
            } else {
                stack.push(i);
            }
        }
        while(!stack.isEmpty()) {
            int pos = stack.pop();
            res[pos] = 0;
        }
        return res;
    }
}
