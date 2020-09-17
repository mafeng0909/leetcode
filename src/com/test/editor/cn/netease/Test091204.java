package com.test.editor.cn.netease;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/9/12
 **/
public class Test091204 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] manId = sc.nextLine().trim().split(" ");
        String[] womenId = sc.nextLine().trim().split(" ");
        int n = sc.nextInt();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(map.containsKey(a)) {
                map.get(a).add(b);
            }else {
                List<Integer> list = new ArrayList<>();
                map.put(a, list);
            }
        }
        System.out.println(Math.min(manId.length, womenId.length));

    }
}
