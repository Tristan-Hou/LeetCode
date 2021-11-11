package com.leetcode;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q125 {
    public boolean isPalindrome(String s) {
        if(s == null) {
            return false;
        }
        int len = s.length();
        if(len == 0) {
            return true;
        }
        int i=0, j=len-1;
        boolean res = true;
        while(i<j) {
            while(i<j && !isTxt(s.charAt(i))) {
                i++;
            }
            while(i<j && !isTxt(s.charAt(j))) {
                j--;
            }
            if(equal(s.charAt(i),  s.charAt(j))) {
                i++;
                j--;
            } else {
                res = false;
            }
        }
         if(i == j && !isTxt(s.charAt(j))) {
            res = false;
        }
        return res;
    }

    private boolean isTxt(char c) {
        if(isChar(c) || isNBum(c)) {
            return true;
        }
        return false;
    }

    private boolean isChar(char c) {
        if(((c-'a')>=0 && (c-'a'<26)) || ((c-'A')>=0 && (c-'A'<26))) {
            return true;
        }
        return false;
    }

    private boolean isNBum(char c) {
        if((c-'0')>=0 && (c-'0'<=9)) {
            return true;
        }
        return false;
    }

    private boolean equal(char a, char b) {
        if (isChar(a) && isChar(b) && (a == b || Math.abs(a-b) == 32)) {
            return true;
        } else if(isNBum(a) && isNBum(b) && a==b) {
            return true;
        }
        return false;
    }
}
