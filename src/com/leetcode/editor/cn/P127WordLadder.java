//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
//
//
//
// 每次转换只能改变一个字母。
// 转换过程中的中间单词必须是字典中的单词。
//
//
// 说明:
//
//
// 如果不存在这样的转换序列，返回 0。
// 所有单词具有相同的长度。
// 所有单词只由小写字母组成。
// 字典中不存在重复的单词。
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
//
//
// 示例 1:
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
//
//
// 示例 2:
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。
// Related Topics 广度优先搜索

package com.leetcode.editor.cn;

import javafx.util.Pair;

import java.util.*;

/**
 * Java：单词接龙
 * 分析：1、将相差一个字母的单词进行连接，构成一张图
 *      2、然后利用bfs进行广度优先搜索找出最短路径
 *
 * @author mafeng
 */
public class P127WordLadder{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Map<String, List<String>> graph = constructGraph(beginWord, wordList);
            return bfs(beginWord, endWord, graph);
        }

        /**
         * 宽度优先搜索 => BFS
         * @param beginWord
         * @param endWord
         * @param graph
         * @return
         */
        public int bfs(String beginWord, String endWord, Map<String, List<String>> graph) {
            ArrayList<String> visited = new ArrayList<>();
            Queue<Pair<String, Integer>> queue = new LinkedList<>();
            visited.add(beginWord);
            queue.add(new Pair<>(beginWord, 1));
            while (!queue.isEmpty()) {
                Pair<String, Integer> node = queue.poll();
                String word = node.getKey();
                Integer step = node.getValue();
                // 临界状态
                if (word.equals(endWord)) {
                    return step;
                }
                List<String> neighborWords = graph.get(word);
                for (String neighborWord : neighborWords) {
                    if (!visited.contains(neighborWord)) {
                        // 将所有未走过的都记录起来，并标记为已走过
                        queue.add(new Pair<>(neighborWord, step + 1));
                        visited.add(neighborWord);
                    }
                }
            }
            return 0;
        }

        /**
         * 构建图
         * @param beginWord
         * @param wordList
         * @return
         */
        public Map<String, List<String>> constructGraph(String beginWord, List<String> wordList) {
            // 防止beginWord不在原始列表中
            wordList.add(beginWord);
            Map<String, List<String>> graph = new HashMap<>(wordList.size());
            for (String word : wordList) {
                graph.put(word, new ArrayList<>());
            }
            for (int i = 0; i < wordList.size(); i++) {
                String word1 = wordList.get(i);
                for (int j = i + 1; j < wordList.size(); j++) {
                    String word2 = wordList.get(j);
                    if (isConnected(word1, word2)) {
                        graph.get(word1).add(word2);
                        graph.get(word2).add(word1);
                    }
                }
            }
            return graph;
        }

        /**
         * 判断两个单词是否可以连接
         * @param word1
         * @param word2
         * @return
         */
        public boolean isConnected(String word1, String word2) {
            int count = 0;
            for (int i = 0; i < word1.length(); i++) {
                if (word1.charAt(i) != word2.charAt(i)) {
                    count++;
                }
            }
            return count == 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
