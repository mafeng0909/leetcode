package com.test.editor.cn.netease;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/9/12
 **/
public class Test091202 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int i = longestSubstring(s);
        System.out.println(i);
    }

    public static int longestSubstring(String s) {
        int target = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int state = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('b', 1);
        map.put('c', 2);
        map.put('x', 3);
        map.put('y', 4);
        map.put('z', 5);
        hm.put(0, -1);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                state ^= 1 << map.get(c);
            }
            if (hm.containsKey(state)) {
                ans = Math.max(ans, i - hm.get(state));
            }else {
                hm.put(state, i);
            }
        }
        return ans;
    }
}
