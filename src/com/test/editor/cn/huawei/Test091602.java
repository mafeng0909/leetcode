package com.test.editor.cn.huawei;

import java.util.*;

/**
 * @author mafeng
 * @data 2020/9/16
 **/
public class Test091602 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        sc.nextLine();
        int n = sc.nextInt();

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();

        for (int i = 0; i < n; i++) {
            sc.nextLine();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (!visited.containsKey(b)) {
                List<Integer> list = new ArrayList<>();
                list.add(a);
                map.put(b, list);
                visited.put(b, false);
            }else {
                List<Integer> list = map.get(b);
                list.add(a);
                map.put(b, list);
            }
            if (!map.containsKey(a)) {
                List<Integer> list = new ArrayList<>();
                list.add(b);
                map.put(a, list);
                visited.put(a, false);
            }else {
                List<Integer> list = map.get(a);
                list.add(b);
                map.put(a, list);
            }
        }

        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        visited.put(start, true);

        dfs(map, start, end, visited, temp, res);


        HashSet<Integer> set = new HashSet<>();
        boolean flag1 = true;
        for (List<Integer> re : res) {
            int size = re.size();
            if (size % 2 != 0) {
                flag1 = false;
                break;
            }
            boolean flag = set.add(size);
            if (!flag) {
                set.remove(size);
            }
        }
        if (flag1) {
            if (set.size() == 0 || set.size() == 1) {
                int count = 0;
                for (List<Integer> re : res) {
                    Integer integer = re.get(re.size() / 2 - 1);
                    count += integer;
                }
                System.out.println(count);
            }else {
                System.out.println(0);
            }
        }else {
            System.out.println(0);
        }

    }

    public static void dfs(HashMap<Integer, List<Integer>> map, int cur, int end, HashMap<Integer, Boolean> visited, List<Integer> temp, List<List<Integer>> res) {
        if (cur == end) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (map.containsKey(cur)) {
            List<Integer> list = map.get(cur);
            for (Integer integer : list) {
                if (visited.get(integer)) {
                    continue;
                }
                visited.put(integer, true);
                temp.add(integer);
                dfs(map, integer, end, visited, temp, res);
                if (list.size() >= 2) {
                    visited.put(integer, false);
                }
                temp.remove(temp.size() - 1);
            }
        }
    }
}
