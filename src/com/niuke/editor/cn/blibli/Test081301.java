package com.niuke.editor.cn.blibli;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mafeng
 * @data 2020/8/13
 **/
public class Test081301 {
    public static void main(String[] args) {

    }

    public boolean game24Points (int[] arr) {
        // write code here
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        return func(list);
    }

    public static boolean func(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i);
            list.remove(i);
            if (getResult(list, temp)) {
                return true;
            }
            list.add(i, temp);
        }
        return false;
    }

    public static boolean getResult(List<Integer> list, int temp) {
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                int n = list.get(i);
                list.remove(i);
                if (getResult(list, temp * n) || getResult(list, temp + n) || getResult(list, temp - n)) {
                    return true;
                }
                else if (temp % n == 0) {
                    if (getResult(list, temp / n)) {
                        return true;
                    }
                }
                list.add(i, n);
            }
            return false;
        }else {
            if (temp == 24) {
                return true;
            }else {
                return false;
            }
        }
    }
}
