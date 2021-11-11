package com.leetcode;

import java.util.Stack;

class Q316 {
    public String removeDuplicateLetters(String s) {
        int[] num = new int[26];
        boolean[] inserted =  new boolean[26];
        int length = s.length();
        for(int i = 0; i < length; i++) {
            num[s.charAt(i) - 'a']++;
        }

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < length; i++) {
            if(!inserted[s.charAt(i) - 'a']) {
                while(!stack.isEmpty() && stack.peek() > s.charAt(i)) {
                    if(num[stack.peek() - 'a'] > 0) {
                        // num[stack.peek() - 'a']--;
                        inserted[stack.pop() - 'a'] = false;
                    } else {
                        break;
                    }
                }
                inserted[s.charAt(i) - 'a'] = true;
                stack.push(s.charAt(i));
            }
            num[s.charAt(i) - 'a']--;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}
