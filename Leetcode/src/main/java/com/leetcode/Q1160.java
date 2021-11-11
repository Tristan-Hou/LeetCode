package com.leetcode;

/**
 * 1160. 拼写单词
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * <p>
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * <p>
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 * <p>
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * 示例 2：
 * <p>
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 */
public class Q1160 {
    public int countCharacters(String[] words, String chars) {
        if (words == null || chars == null || "".equals(chars)) {
            return 0;
        }
        int[] charsTable = new int[26];
        int charsLen = chars.length();
        for (int i = 0; i < charsLen; i++) {
            charsTable[chars.charAt(i) - 97]++;
        }
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            boolean addResult = true;
            String word = words[i];
            int[] wordTable = new int[26];
            for (int j = 0; j < word.length(); j++) {
                wordTable[word.charAt(j) - 97]++;
            }
            for (int j = 0; j < 26; j++) {
                if (wordTable[j] > charsTable[j]) {
                    addResult = false;
                    break;
                }
            }
            if (addResult) {
                result += word.length();
            }
        }
        return result;
    }

}
