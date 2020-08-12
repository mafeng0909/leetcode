package com.test.editor.cn.shopee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/8/12
 **/
public class Test081202 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String[] str = s1.substring(1, s1.length() - 1).split(",");

        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (String s : str) {
            int temp = Integer.parseInt(s);
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            }else {
                map.put(temp, 1);
            }
        }
        for(int i : map.keySet()){
            if (map.get(i) > str.length / 3) {
                res.add(i);
            }
        }
        System.out.println(res.toString());
    }
}
