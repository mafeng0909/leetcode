package com.test.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author mafeng
 * @data 2020/9/28
 **/
public class Test0928 {
    public static void main(String[] args) {
//        int x;
//        int y;
//        for (x = 1, y = 1; x <= 100; x++) {
//            if (y >= 20) {
//                break;
//            }
//            if (y % 3 == 1) {
//                y += 3;
//                continue;
//            }
//            y -= 5;
//        }
//        System.out.println(x);
//        System.out.println(y);
//        try {
//            System.out.println("hello");
//            RtException.throwIt();
//        }catch (Exception e) {
//            System.out.println("catch");
//        }finally {
//            System.out.println("finally");
//        }
//        System.out.println("after");
        String s = "19 5 9 255 9 19 256";
        System.out.println(sort(s));
    }

//    public static class RtException{
//        public static void throwIt() {
//            System.out.println("throwIt");
//            throw new RuntimeException();
//        }
//    }

    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        ArrayList<Integer> stack = new ArrayList<>();
        stack.add(nums[0]);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (stack.get(stack.size() - 1) < nums[i]) {
                stack.add(nums[i]);
            } else {
                for (int j = 0; j < stack.size(); j++) {
                    if (stack.get(j) >= nums[i]) {
                        stack.set(j, nums[i]);
                        break;
                    }
                }
            }
        }
        return stack.size();
    }

    public static int sort(String inData) {
        // 局部内部类
        class Item {
            int index;
            int val;

            public Item(int index, int val) {
                this.index = index;
                this.val = val;
            }
        }

        String[] arr = inData.split(" ");
        int len = arr.length;
        Item[] nums = new Item[len];
        // 考虑重复值
        for (int i = 0; i < len; i++) {
            nums[i] = new Item(i, Integer.parseInt(arr[i]));
        }

        int res = 0;
        int pos = len;
        Arrays.sort(nums, Comparator.comparingInt(o -> o.val));
        for (int i = 0; i < len - 1; i++) {
            if (nums[i].val < nums[i + 1].val && nums[i].index > nums[i + 1].index) {
                // 调整 nums[i+1] 的 index
                nums[i + 1].index = pos++;
                res++;
            }
        }

        return res;
    }
}
