package com.test.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/9/10
 **/
public class Test0910 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        HashSet<String> res = new HashSet<>();
        List<Character> temp = new ArrayList<>();
        int[] visited = new int[chars.length];

        dfs(chars, 0, visited, temp, res);
        System.out.println(res.size());
    }

    public static void dfs(char[] chars, int index, int[] visited, List<Character> temp, HashSet<String> res) {
        if (index == chars.length) {
            StringBuilder sb = new StringBuilder();
            for (Character character : temp) {
                sb.append(character);
            }
            res.add(sb.toString());
        }

        for (int i = 0; i < chars.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            temp.add(chars[i]);
            visited[i] = 1;
            dfs(chars, index + 1, visited, temp, res);
            temp.remove(temp.size() - 1);
            visited[i] = 0;
        }
    }
}
