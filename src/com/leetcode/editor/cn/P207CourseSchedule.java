//你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。 
//
// 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1] 
//
// 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？ 
//
// 
//
// 示例 1: 
//
// 输入: 2, [[1,0]] 
//输出: true
//解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。 
//
// 示例 2: 
//
// 输入: 2, [[1,0],[0,1]]
//输出: false
//解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。 
// 你可以假定输入的先决条件中没有重复的边。 
// 1 <= numCourses <= 10^5 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序

package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Java：课程表
 * 分析：就是判断是否存在闭环  AOV网络
 * @author mafeng
 */
public class P207CourseSchedule{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        // 方法一：深度优先遍历
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            // 存储每个节点可以通向哪些节点，即哪些节点依赖于此节点
            List<List<Integer>> lists = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                lists.add(new ArrayList<>());
            }
            // 将目标二维进行变形
            for (int[] prerequisite : prerequisites) {
                lists.get(prerequisite[1]).add(prerequisite[0]);
            }
            // 记录每个节点被遍历的状态
            // -1：已被其他节点访问
            // 0：未被访问
            // 1：已被当前节点访问
            int[] visitFlag = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                if (!dfs(lists, visitFlag, i)) {
                    return false;
                }
            }
            return true;
        }

        public boolean dfs(List<List<Integer>> lists, int[] visitFlag, int i) {
            // 如果已经被当前节点已经访问，则说明这是第二次访问，即存在闭环，返回false
            if (visitFlag[i] == 1) {
                return false;
            }
            // 如果被其他节点访问过，则直接返回true
            if (visitFlag[i] == -1) {
                return true;
            }
            visitFlag[i] = 1;
            for (Integer j : lists.get(i)) {
                if (!dfs(lists, visitFlag, j)) {
                    return false;
                }
            }
            // 该节点访问完之后将状态置为 -1 ，告诉其他节点该节点已被其他节点访问
            visitFlag[i] = -1;
            return true;
        }

        // 方法二：宽度优先遍历（拓扑排序 入度）
        public boolean canFinish2(int numCourses, int[][] prerequisites) {
            List<List<Integer>> lists = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                lists.add(new ArrayList<>());
            }
            int[] inDegrees = new int[numCourses];
            for (int[] prerequisite : prerequisites) {
                inDegrees[prerequisite[0]]++;
                lists.get(prerequisite[1]).add(prerequisite[0]);
            }
            Queue<Integer> queue = new LinkedList<>();
            // 将入度为零的加入到队列中
            for (int i = 0; i < numCourses; i++) {
                if (inDegrees[i] == 0) {
                    queue.add(i);
                }
            }
            while (!queue.isEmpty()) {
                Integer i = queue.poll();
                numCourses--;
                for (Integer j : lists.get(i)) {
                    inDegrees[j]--;
                    if (inDegrees[j] == 0) {
                        queue.add(j);
                    }
                }
            }
            return numCourses == 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}