//给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
//
//
//
// 示例：
//
// 给出如下 3x6 的高度图:
//[
//  [1,4,3,1,3,2],
//  [3,2,1,3,2,4],
//  [2,3,3,2,3,1]
//]
//
//返回 4 。
//
//
//
//
// 如上图所示，这是下雨前的高度图[[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] 的状态。
//
//
//
//
//
// 下雨后，雨水将会被存储在这些方块中。总的接雨水量是4。
//
//
//
// 提示：
//
//
// 1 <= m, n <= 110
// 0 <= heightMap[i][j] <= 20000
//
// Related Topics 堆 广度优先搜索

package com.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Java：接雨水 II
 * 分析：BFS
 * @author mafeng
 */
public class P407TrappingRainWaterIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public int trapRainWater(int[][] heightMap) {
            if (heightMap.length < 3 || heightMap[0].length < 3) {
                return 0;
            }
            int row = heightMap.length;
            int col = heightMap[0].length;
            // 定义一个小顶堆， 以高度为排序标准
            Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
            // 定义一个二维数组，记录是否访问过
            int[][] visited = new int[row][col];
            for (int[] ints : visited) {
                Arrays.fill(ints, 0);
            }

            // 1、将矩阵的四周依次加入到小顶堆中
            // 将第一列和最后一列加入到queue
            for (int i = 0; i < row; i++) {
                queue.add(new int[]{i, 0, heightMap[i][0]});
                visited[i][0] = 1;
                queue.add(new int[]{i, col - 1, heightMap[i][col - 1]});
                visited[i][col - 1] = 1;
            }
            // 将第一行和最后一行加入到queue
            for (int j = 1; j < col - 1; j++) {
                queue.add(new int[]{0, j, heightMap[0][j]});
                visited[0][j] = 1;
                queue.add(new int[]{row - 1, j, heightMap[row - 1][j]});
                visited[row - 1][j] = 1;
            }

            // 利用方向数组
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            // 记录最大积水量
            int result = 0;
            while (!queue.isEmpty()) {
                int[] arr = queue.poll();
                int h = arr[2];
                for (int i = 0; i < dx.length; i++) {
                    int newX = arr[0] + dx[i];
                    int newY = arr[1] + dy[i];
                    // 临界条件
                    if (newX < 0 || newX >= row || newY < 0 || newY >= col
                            || visited[newX][newY] == 1) {
                        continue;
                    }
                    // 如果当前高度比遍历的最低高度h还低，则说明可以积水
                    if (h > heightMap[newX][newY]) {
                        result += h - heightMap[newX][newY];
                        // 更新高度
                        heightMap[newX][newY] = h;
                    }
                    queue.add(new int[]{newX, newY, heightMap[newX][newY]});
                    // 标记已遍历过
                    visited[newX][newY] = 1;
                }
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
