//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 335 👎 0


package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Java：杨辉三角
 * 
 * @author: mafeng
 * @data: 2020-08-03 22:44:47
 **/
public class P118PascalsTriangle{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public List<List<Integer>> generate(int numRows) {
            int[][] temp = new int[numRows][numRows];
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                // 每一行的第一个元素均为1
                temp[i][0] = 1;
                List<Integer> list = new ArrayList<>();
                list.add(temp[i][0]);
                // 第i行总共有i个元素
                for (int j = 1; j <= i; j++) {
                    // 转换方程
                    temp[i][j] = temp[i - 1][j - 1] + temp[i - 1][j];
                    list.add(temp[i][j]);
                }
                res.add(list);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}