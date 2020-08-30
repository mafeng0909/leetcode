package com.test.editor.cn.nongyebank;

/**
 * @author mafeng
 * @data 2020/8/29
 **/
public class Test082902 {
    public static void main(String[] args) {
        String[] s = {"1,1", "2,2", "1,3", "1,4"};
        int min = findMin(s);
        System.out.println(min);
    }

    public static int findMin(String[] points) {
        // 1、将字符串转为二维数组
        int[][] arr = new int[points.length][2];
        int index = 0;
        for (String s1 : points) {
            String[] strings = s1.split(",");
            arr[index][0] = Integer.parseInt(strings[0]);
            arr[index][1] = Integer.parseInt(strings[1]);
            index++;
        }

        // 2、算出质点
        double sumX = 0;
        double sumY = 0;
        for (int i = 0; i < points.length; i++) {
            sumX += arr[i][0];
            sumY += arr[i][1];
        }
        double x0 = sumX * 1000 / points.length / 1000;
        double y0 = sumY * 1000 / points.length / 1000;

        // 3、求最短距离
        double distance = Double.MAX_VALUE;
        int resIndex = -1;
        for (int i = 0; i < points.length; i++) {
            double x = x0 - arr[i][0];
            double y = y0 - arr[i][1];
            double res = Math.pow(x, 2) + Math.pow(y, 2);
            if (distance > res) {
                distance = res;
                resIndex = i;
            }
        }
        return resIndex;
    }
}
