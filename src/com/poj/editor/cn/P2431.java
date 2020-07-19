package com.poj.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 最优加油方案
 * 方法：贪心算法
 *
 * @author mafeng
 * @date 2020/4/30 16:32
 */
public class P2431 {
    public static void main(String[] args) {

    }

    /**
     * 获取最少加油次数
     * @param startLen 起点到终点的距离
     * @param gas 起始拥有的总油量
     * @param gasStations 每个加油站的信息：0 -> 距离终点的距离  1 -> 所拥有的油量
     * @return 返回最少加油次数
     */
    public static int getMinTimes(int startLen, int gas, int[][] gasStations) {
        // 体现贪心思想
        // 定义一个大顶堆，存储每个加油站的油量，保证每次取出来的都是最大的
        PriorityQueue<Integer> maxGas = new PriorityQueue<>((n1, n2) -> n2 - n1);
        Arrays.sort(gasStations, (o1, o2) -> o2[0] - o1[0]);
        int len = startLen;
        int addGasTimes = 0;
        for (int[] gasStation : gasStations) {
            // 计算出当前位置与遍历到的加油站之间的距离
            int lenOfGas = len - gasStation[0];
            while (!maxGas.isEmpty() && gas < lenOfGas) {
                addGasTimes++;
                gas += maxGas.poll();
            }
            if (maxGas.isEmpty() && gas < lenOfGas) {
                return -1;
            }
            // 可以到达遍历的加油站，便往前走，到达该加油站，计算出剩余的油量
            gas = gas - lenOfGas;
            // 更新当前位置距离终点的距离
            len = gasStation[0];
            // 往堆中加入该加油站能加的油量
            maxGas.add(gasStation[1]);
        }
        return addGasTimes;
    }
}
