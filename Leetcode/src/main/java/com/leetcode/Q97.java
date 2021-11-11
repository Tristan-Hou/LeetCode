package com.leetcode;

/**
 * 97. 交错字符串
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出：true
 * 示例 2：
 *
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出：false
 */
public class Q97
{

    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        if(l3 != l1 + l2) {
            return false;
        }
        boolean[][] dp = new boolean[l1+1][l2+1];
        dp[0][0] = true;
        for(int i=1; i<l1+1 && s1.charAt(i-1) == s3.charAt(i-1); i++) {
            dp[i][0] = true;
        }
        for(int i=1; i<l2+1 && s2.charAt(i-1) == s3.charAt(i-1); i++) {
            dp[0][i] = true;
        }
        for(int i=1; i<l1+1; i++) {
            for(int j=1; j<l2+1; j++) {
                dp[i][j] = (dp[i-1][j] && s3.charAt(i+j-1) == s1.charAt(i-1))
                        || (dp[i][j-1] && s3.charAt(i+j-1) == s2.charAt(j-1));
            }
        }
        return dp[l1][l2];


        // int m = s1.length(), n = s2.length();
        // if (s3.length() != m + n) return false;
        // // 动态规划，dp[i,j]表示s1前i字符能与s2前j字符组成s3前i+j个字符；
        // boolean[][] dp = new boolean[m+1][n+1];
        // dp[0][0] = true;
        // for (int i = 1; i <= m && s1.charAt(i-1) == s3.charAt(i-1); i++) dp[i][0] = true; // 不相符直接终止
        // for (int j = 1; j <= n && s2.charAt(j-1) == s3.charAt(j-1); j++) dp[0][j] = true; // 不相符直接终止
        // for (int i = 1; i <= m; i++) {
        //     for (int j = 1; j <= n; j++) {
        //         dp[i][j] = (dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1))
        //             || (dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1));
        //     }
        // }
        // return dp[m][n];
    }
}
