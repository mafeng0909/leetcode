//给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。 
//
// 数学表达式如下: 
//
// 如果存在这样的 i, j, k, 且满足 0 ≤ i < j < k ≤ n-1， 
//使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。 
//
// 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5]
//输出: true
// 
//
// 示例 2: 
//
// 输入: [5,4,3,2,1]
//输出: false 
// 👍 179 👎 0


package com.leetcode.editor.cn;
/**
 * Java：递增的三元子序列
 * 分析：选定一个最小的数和一个第二小的数
 *      遍历数组，不断更新最小的和第二小的数（不同时更新）
 * 
 * @author: mafeng
 * @data: 2020-08-01 21:42:54
 **/
public class P334IncreasingTripletSubsequence{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        int[] arr = {3, 5, 2, 1, 4};
        System.out.println(solution.increasingTriplet(arr));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public boolean increasingTriplet(int[] nums) {
            int first = Integer.MAX_VALUE;
            int second = Integer.MAX_VALUE;
            for(int num : nums){
                if(num <= first) {
                    first = num;
                } else if(num <= second) {
                    second = num;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}