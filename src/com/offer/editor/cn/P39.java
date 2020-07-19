package com.offer.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mafeng
 * 题目：求数组中出现次数超过一半的数
 * 分析：1. 如果有一个数出现次数超过数组长度一半，则不相同的数应该小于数组长度的一半
 *      2. 如果有一个数出现次数超过数组长度一半，则最少有两个相同的数挨着
 *
 * @date 2020/7/14 22:53
 */
public class P39 {
    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int res = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                Integer integer = map.get(num);
                if (max < integer + 1) {
                    max = integer + 1;
                    res = num;
                }
                map.put(num, integer + 1);
            } else {
                map.put(num, 1);
            }
        }
        return max * 2 > nums.length - 1 ? res : 0;
    }

    public int majorityElement2(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (candidate == num ? 1 : -1);
        }
        return count > 0 ? candidate : 0;
    }

}
