package com.leetcode;

public class Q331 {

    int index = 0;
    int n;
    public boolean isValidSerialization(String preorder) {
        n = preorder.length();
        if(n <= 0) {
            return false;
        }
        return isTree(preorder);
    }

    public boolean isTree(String s) {
        if( s.charAt(index) == '#') {
            index++;
            return true;
        }

        char c = s.charAt(index++);
        boolean isNumber = (Character.isDigit(c));
        while(index < n && (s.charAt(index) != ',') ) {
            index++;
        }
        boolean left = false;
        if(index < n) {
            index++;
            left = isTree(s);
        }
        boolean right = false;
        if(index < n) {
            index++;
            right = isTree(s);
        }
        return isNumber && left && right;
    }
}
