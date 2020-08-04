//给定一个Excel表格中的列名称，返回其相应的列序号。 
//
// 例如， 
//
//     A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28 
//    ...
// 
//
// 示例 1: 
//
// 输入: "A"
//输出: 1
// 
//
// 示例 2: 
//
// 输入: "AB"
//输出: 28
// 
//
// 示例 3: 
//
// 输入: "ZY"
//输出: 701 
//
// 致谢： 
//特别感谢 @ts 添加此问题并创建所有测试用例。 
// Related Topics 数学 
// 👍 163 👎 0


package com.leetcode.editor.cn;
/**
 * Java：Excel表列序号
 * 
 * @author: mafeng
 * @data: 2020-08-03 21:38:19
 **/
public class P171ExcelSheetColumnNumber{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public int titleToNumber(String s) {
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                // 26进制
                res = res * 26 + s.charAt(i) - 'A' + 1;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}