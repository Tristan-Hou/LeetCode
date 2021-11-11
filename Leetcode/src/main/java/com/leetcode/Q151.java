package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * <p>
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q151 {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int i = -1;
        int j = -1;
        int size = s.length();
        List<Integer> list = new ArrayList<>();
        for (int index = 0; index < size; index++) {
            char c = s.charAt(index);
            if (i == -1) {
                if (c != ' ') {
                    i = index;
                    list.add(i);
                }
            } else {
                if (c == ' ' || c == '\0') {
                    j = index - 1;
                    list.add(j);
                    i = -1;
                    j = -1;
                }
            }
        }
        int len = list.size();
        if ((len & 1) == 1) {
            list.add(size - 1);
            len = list.size();
        }
        if (len < 2) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int k = len - 1; k >= 0; k -= 2) {
            int m = list.get(k - 1);
            int n = list.get(k);
            sb.append(s.substring(m, n + 1));
            sb.append(" ");
        }
        int l = sb.toString().length();
        sb.deleteCharAt(l - 1);

        return sb.toString();
    }

}
