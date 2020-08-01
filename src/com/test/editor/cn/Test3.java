package com.test.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/7/31
 **/
public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        // 换行，即读取换行标志位
        scanner.nextLine();

        List<Integer> list = new ArrayList<>();
        // scanner.hasNext() 判断是否有换行符
        while (scanner.hasNext()) {
            list.add(scanner.nextInt());
            if (list.size() >= num) {
                break;
            }
        }
        scanner.nextLine();
        int target = scanner.nextInt();
        System.out.println(num);
        System.out.println(list);
        System.out.println(target);
    }
}
