package com.test.editor.cn;

import java.util.*;

/**
 * @author mafeng
 * @data 2020/9/10
 **/
public class Test091002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strings = s.trim().split(" ");
        int[] arr = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }

//        int[] arr = {1, 2, 1, 3, 2, 5};
        List<Integer> list = find(arr);
        System.out.println(list);
    }

    public static List<Integer> find(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            boolean flag = set.add(i);
            if (!flag) {
                set.remove(i);
            }
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        return list;

    }
}
