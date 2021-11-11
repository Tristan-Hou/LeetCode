package com.leetcode;

import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 *
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 *
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 *
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q394 {

    public String decodeString(String s) {
        Stack stack = new Stack();
        StringBuilder res = new StringBuilder();
        // String tmp = null;
        String tmp = s;
        int len = s.length();
        int i=0;
        while(i < len) {
            int num = Integer.MIN_VALUE;
            // boolean isNum = false;
            while(i < len && s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
                if(num == Integer.MIN_VALUE) {
                    num = s.charAt(i) - '0';
                } else {
                    num = num * 10 + s.charAt(i) - '0';;
                }
                i++;
            }
            if(num != Integer.MIN_VALUE) {
                stack.push(num);
                continue;
            }
            if(s.charAt(i) == '[') {
                stack.push(s.charAt(i));
                i++;
                continue;
            }
            StringBuilder sb = new StringBuilder();
            while(i < len && !(s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) && !(s.charAt(i) == '[') && !(s.charAt(i) == ']')) {
                sb.append(s.charAt(i));
                i++;
            }
            if (stack.isEmpty()) {
                res.append(sb);
                continue;
            } else if(sb.toString().length() != 0) {
                stack.push(sb.toString());
                continue;
            }
            if(s.charAt(i) == ']') {
                String x = doRight(stack);
                if(!stack.isEmpty()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    while(!(stack.peek().equals('['))) {
                        stringBuilder.append(stack.pop());
                    }
                    stringBuilder.append(x);
                    stack.push(stringBuilder.toString());
                } else {
                    res.append(x);
                }
                i++;
            }
        }
        if (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.toString();
    }

    private String doRight(Stack stack) {
        String txt = (String) stack.pop();
        stack.pop();
        int num = (Integer) stack.pop();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<num; i++) {
            sb.append(txt);
        }
        return sb.toString();
    }
}
