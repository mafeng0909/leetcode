//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组 
// 👍 166 👎 0


package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Java：杨辉三角 II
 * 
 * @author: mafeng
 * @data: 2020-08-03 23:21:19
 **/
public class P119PascalsTriangleIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public List<Integer> getRow(int rowIndex) {
            int[][] arr = new int[rowIndex + 1][rowIndex + 1];
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i <= rowIndex; i++) {
                arr[i][0] = 1;
                List<Integer> list = new ArrayList<>();
                list.add(arr[i][0]);
                for (int j = 1; j <= i; j++) {
                    // 状态转换方程
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                    list.add(arr[i][j]);
                }
                res = list;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}