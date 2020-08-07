package com.niuke.editor.cn.netease;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 题目：https://www.nowcoder.com/practice/0385945b7d834a99bc0010e67f892e38?tpId=122&&tqId=33653&rp=1&ru=/ta/exam-wangyi&qru=/ta/exam-wangyi/question-ranking
 * 分析：题意是说去最坏的情况，所以利用Bfs进行搜索遍历，找出走到每个点所能走的步数
 *      最后统计出最大的那个就是答案
 *
 * @author mafeng
 * @data 2020/8/7
 **/
public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 读取矩阵
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        char[][] chars = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            char[] charArray = s.toCharArray();
            System.arraycopy(charArray, 0, chars[i], 0, charArray.length);
        }
        // 读取初始坐标
        int x0 = sc.nextInt();
        int y0 = sc.nextInt();
        sc.nextLine();
        // 读取移动的规则
        String s = sc.nextLine();
        int k = Integer.parseInt(s);
        int[] dx = new int[k];
        int[] dy = new int[k];
        for (int i = 0; i < k; i++) {
            dx[i] = sc.nextInt();
            dy[i] = sc.nextInt();
            sc.nextLine();
        }

        // 定义一个二维数组，表示到达每一个点所需要的步数（实际结果+1）
        int[][] visitNum = new int[n][m];
        visitNum[x0][y0] = 1;

        // 记录bfs的每一轮的点
        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();
        queueX.add(x0);
        queueY.add(y0);

        while (!queueX.isEmpty() && !queueY.isEmpty()) {
            Integer tempX = queueX.poll();
            Integer tempY = queueY.poll();
            for (int i = 0; i < k; i++) {
                int newTempX = tempX + dx[i];
                int newTempY = tempY + dy[i];
                if (newTempX >= 0 && newTempX < n && newTempY >= 0 && newTempY < m) {
                    if (visitNum[newTempX][newTempY] == 0) {
                        if (chars[newTempX][newTempY] == '.') {
                            // 更新visitNum
                            visitNum[newTempX][newTempY] = visitNum[tempX][tempY] + 1;
                            // 将该点加入到队列中
                            queueX.add(newTempX);
                            queueY.add(newTempY);
                        }else {
                            visitNum[newTempX][newTempY] = -1;
                        }
                    }
                }
            }
        }

        int max = 0;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 有可能还有一些点不可达
                if (visitNum[i][j] == 0 && chars[i][j] == '.') {
                    flag = false;
                }else {
                    max = Math.max(max, visitNum[i][j]);
                }
            }
        }
        if (flag) {
            System.out.println(max - 1);
        }else {
            System.out.println(-1);
        }
    }
}
