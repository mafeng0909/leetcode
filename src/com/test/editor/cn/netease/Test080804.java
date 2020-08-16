package com.test.editor.cn.netease;



/**
 * @author mafeng
 * @data 2020/8/8
 **/
public class Test080804 {
    public static void main(String[] args) {
        String str = "mafeng";
        String str1 = "mafeng";
        String str3 = new String("mafeng");
        System.out.println(str.equals(str1));
        System.out.println(str == str1);
        System.out.println(str.equals(str3));
        System.out.println(str == str3);
    }
}
