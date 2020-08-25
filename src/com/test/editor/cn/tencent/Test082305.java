package com.test.editor.cn.tencent;

import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/8/23
 **/
public class Test082305 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = sc.nextInt();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int left = sc.nextInt();
            int right = sc.nextInt();
            sc.nextLine();

            int cutNum = minCut(s.substring(left - 1, right));
            res[i] = cutNum + 1;
        }
        for (int re : res) {
            System.out.println(re);
        }
    }

    public static int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            dp[i] = isPalindrome(s.substring(0, i + 1)) ? 0 : i - 1;
            for (int j = 1; j >= 1; j--) {
                if (isPalindrome(s.substring(j, i + 1))) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[s.length() - 1];
    }

    private static boolean isPalindrome(String substring) {
        int begin = 0;
        int end = substring.length() - 1;
        while (begin < end) {
            if (substring.charAt(begin) != substring.charAt(end)) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }

    public static int longestPalindrome(String s, int left1, int right1) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int count = 0;
        int left = left1;
        int right = left1;
        // 定义left和right来记录所查找的最长回文子串的前后索引
        for (int i = 0; i <= right1; i++) {
            // 以中心向两端进行查找
            // 由于有奇偶之分，中心有一个数和两个数两种可能，例如：aba 或 abba
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            // 当前找到的长度大于之前已经找到的长度，则更新前后索引
            if (len > right - left) {
                left = i - (len - 1) / 2;
                right = i + len / 2;
            }
        }
        count++;
        if (left1 < left) {
            count += longestPalindrome(s, left1, left);
        }else if (right < right1) {
            count += longestPalindrome(s, right, right1);
        }
        return count;
//        return s.substring(left, right + 1);
    }

    public static int expandAroundCenter(String s, int left, int right) {
        int l = left;
        int r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}
