package com.commonalgorithms.editor.cn;

import java.util.List;

/**
 * @author mafeng
 * @data 2020/8/20
 **/
public class P01PrimAlgorithms {
    public static void main(String[] args) {
        char[] data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int len = data.length;
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000}
            };

        // 构建一个图
        Graph graph = new Graph(len);
        // 填充图
        createGraph(graph, len, data, weight);


        
    }

    public static void prim(Graph graph, int index, List<Character> res) {
        // 标记数组
        int[] visited = new int[graph.num];

    }

    public static void createGraph(Graph graph, int num, char[] data, int[][] weight) {
        for (int i = 0; i < num; i++) {
            graph.data[i] = data[i];
            System.arraycopy(weight[i], 0, graph.weight[i], 0, num);
        }
    }

    static class Graph {
        int num;
        char[] data;
        int[][] weight;

        public Graph(int num) {
            this.num = num;
            this.data = new char[num];
            this.weight = new int[num][num];
        }
    }
}
