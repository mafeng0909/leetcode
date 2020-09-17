package com.test.editor.cn.xiecheng;

import java.util.*;

/**
 * @author mafeng
 * @data 2020/9/8
 **/
public class Test090801 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String targetString = sc.nextLine();
        /*String s = sc.nextLine();
        String replaceString = sc.nextLine();*/

        char[] chars = targetString.toCharArray();

        int[] visited = new int[chars.length];
        Set<String> targetList = new HashSet<>();
        List<Character> temp = new ArrayList<>();
        dfs(chars, 0, visited, temp, targetList);
        System.out.println(targetList);
    }

    public static void dfs(char[] chars, int index, int[] visited, List<Character> temp, Set<String> list) {
        if (index == chars.length) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Character character : temp) {
                stringBuilder.append(character);
            }
            list.add(stringBuilder.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            temp.add(chars[i]);
            dfs(chars, index + 1, visited, temp, list);
            temp.remove(temp.size() - 1);
            visited[i] = 0;
        }
    }
}
