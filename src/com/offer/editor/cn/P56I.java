package com.offer.editor.cn;

/**
 * @author mafeng
 * 题目：寻找数组中只出现一次的数字
 *      有两个数只出现了一次，其他的数均出现了两次
 * 分析：已知如果只有一个只出现一次的数，那就直接一遍异或即可
 *      现在有两个，则可以将其分组进行查找
 *
 * @data 2020/7/25
 **/
public class P56I {
    public static void main(String[] args) {
        int[] nums1 = {1, 4, 3, 1, 4};
        System.out.println(searchNumber1(nums1));
    }

    /**
     * 题目：寻找数组中只出现一次的数字
     * 描述：只有一个数字出现了一次，其他的都出现了两次
     * 分析：将所有的数进行异或，最后得出的结果就是只出现一次的数
     *      一个数与自身异或，结果为0
     *      一个数与0异或，结果为自身
     *
     * @param nums
     * @return
     */
    public static int searchNumber1(int[] nums) {
        int singleNum = 0;
        for (int num : nums) {
            singleNum ^= num;
        }
        return singleNum;
    }

    public static int[] searchNumber2(int[] nums) {
        // 数组中所有元素异或的结果
        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }
        // 寻找最右边是1的那一位
        int divideFlag = 1;
        while ((ret & divideFlag) == 0) {
            // 将其左移一位
            divideFlag <<= 1;
        }
        // 第一组和第二组的出现一次的元素
        int num1 = 0;
        int num2 = 0;
        for (int num : nums) {
            // 将nums进行分组，并对每组中的元素进行异或
            if ((num & divideFlag) != 0) {
                num1 ^= num;
            }else {
                num2 ^= num;
            }
        }
        return new int[]{num1, num2};
    }
}
