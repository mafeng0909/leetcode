//在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以y坐标并不重要，因此只要知道开始和结束的x
//坐标就足够了。开始坐标总是小于结束坐标。平面内最多存在104个气球。 
//
// 一支弓箭可以沿着x轴从不同点完全垂直地射出。在坐标x处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足 xstart ≤
// x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量
//。 
//
// Example: 
//
// 
//输入:
//[[10,16], [2,8], [1,6], [7,12]]
//
//输出:
//2
//
//解释:
//对于该样例，我们可以在x = 6（射爆[2,8],[1,6]两个气球）和 x = 11（射爆另外两个气球）。
// 
// Related Topics 贪心算法

package com.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Java：用最少数量的箭引爆气球
 * @author mafeng
 */
public class P452MinimumNumberOfArrowsToBurstBalloons{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public int findMinArrowShots(int[][] points) {
            if (points.length == 0) {
                return 0;
            }
            Arrays.sort(points, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) {
                        return o1[1] - o2[1];
                    }else {
                        return o1[0] - o2[0];
                    }
                }
            });
            int shootTimes = 1;
            int shootBegin = points[0][0];
            int shootEnd = points[0][1];
            for (int[] point : points) {
                // 由于已经排好序，所以point[0]是递增的（包含相等）
                if (point[0] <= shootEnd) {
                    shootBegin = point[0];
                    if (point[1] <= shootEnd) {
                        shootEnd = point[1];
                    }
                }else {
                    shootTimes++;
                    shootBegin = point[0];
                    shootEnd = point[1];
                }
            }
            return shootTimes;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}