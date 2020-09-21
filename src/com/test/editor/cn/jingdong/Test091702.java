package com.test.editor.cn.jingdong;

import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/9/17
 **/
public class Test091702 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            sc.nextLine();
            char[][] chars = new char[row][col];
            int startX = -1;
            int startY = -1;
//            int endX = -1;
//            int endY = -1;
            for (int j = 0; j < row; j++) {
                String s = sc.nextLine().trim();
                for (int k = 0; k < s.length(); k++) {
                    chars[j][k] = s.charAt(k);
                    if (s.charAt(k) == 'S') {
                        startX = j;
                        startY = k;
                    }
//                    if (s.charAt(k) == 'E') {
//                        endX = j;
//                        endY = k;
//                    }
                }
            }

            // 判断是否可以
            boolean flag = dfs(chars, startX, startY);
            if (flag) {
                res[i] = 1;
            }

        }
        for (int re : res) {
            if (re == 1) {
                System.out.println("YES");
            }else if (re == 0){
                System.out.println("NO");
            }
        }
    }

    public static boolean dfs(char[][] chars, int x, int y) {
        if (x < 0 || x >= chars.length || y < 0 || y >= chars[0].length || chars[x][y] == '#') {
            return false;
        }
        if (chars[x][y] == 'E') {
            return true;
        }

        chars[x][y] = '#';
        boolean flag1 = dfs(chars, x + 1, y);
        boolean flag2 = dfs(chars, x, y + 1);
        boolean flag3 = dfs(chars, x - 1, y);
        boolean flag4 = dfs(chars, x, y - 1);
        if (flag1 || flag2 || flag3 || flag4) {
            return true;
        }else {
            chars[x][y] = '.';
            return false;
        }
    }
}
