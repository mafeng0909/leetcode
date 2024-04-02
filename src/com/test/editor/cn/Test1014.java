package com.test.editor.cn;

/**
 * @author mafeng
 * @data 2020/10/14
 **/
public class Test1014 {

    private static int a;

    public static void main(String[] args) {

//        Integer b = 0;
//        String s1 = "123";
//        String s2 = new String(s1);
//        String s3 = new String("123");
//        int i = new Integer(28);
//        Integer j = new Integer(i);
//
//        System.out.println(a == b);
//        System.out.println(s1 == s2);
//        System.out.println(s3 == s2);
//        System.out.println(i == j);

        Test t2 = new Test();

    }

    public static class Test {
        public static Test t1 = new Test();

        static {
            System.out.println("blockB");
        }
        {
            System.out.println("blockA");
        }
    }
}
