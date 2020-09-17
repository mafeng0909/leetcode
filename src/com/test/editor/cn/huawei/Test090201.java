package com.test.editor.cn.huawei;

import java.util.*;

/**
 * @author mafeng
 * @data 2020/9/2
 **/
public class Test090201 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 3) {
            System.out.println("null");
        }else {
            sc.nextLine();
            Map<Integer, Integer> treeMap1 = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer a, Integer b) {
                    return b - a;
                }
            });
            Map<Integer, Integer> treeMap2 = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer a, Integer b) {
                    return b - a;
                }
            });

            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                int colour = sc.nextInt();
                if (colour == 1) {
                    treeMap1.put(num, i + 1);
                } else {
                    treeMap2.put(num, i + 1);
                }
                sc.nextLine();
            }

            int sum1 = 0;
            int[] index1 = new int[3];
            int count1 = 0;
            int minIndex1 = n;
            for (int i : treeMap1.keySet()) {
                if (count1 == 3) {
                    break;
                }
                index1[count1] = treeMap1.get(i);
                sum1 += i;
                count1++;
                minIndex1 = treeMap1.get(i) < minIndex1 ? treeMap1.get(i) : minIndex1;

            }

            int sum2 = 0;
            int[] index2 = new int[3];
            int count2 = 0;
            int minIndex2 = n;
            for (int i : treeMap2.keySet()) {
                if (count2 == 3) {
                    break;
                }
                index2[count2] = treeMap2.get(i);
                sum2 += i;
                count2++;
                minIndex2 = treeMap2.get(i) < minIndex2 ? treeMap2.get(i) : minIndex2;
            }
            Arrays.sort(index1);
            Arrays.sort(index2);
            if (sum1 > sum2) {
                System.out.println(index1[0] + " " + index1[1] + " " + index1[2]);
                System.out.println(1);
                System.out.println(sum1);
            } else if (sum1 < sum2) {
                System.out.println(index2[0] + " " + index2[1] + " " + index2[2]);
                System.out.println(2);
                System.out.println(sum2);
            } else {
                if (minIndex1 < minIndex2) {
                    System.out.println(index1[0] + " " + index1[1] + " " + index1[2]);
                    System.out.println(1);
                    System.out.println(sum1);
                } else {
                    System.out.println(index2[0] + " " + index2[1] + " " + index2[2]);
                    System.out.println(2);
                    System.out.println(sum2);
                }
            }
        }
    }
}
