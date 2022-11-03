package org.peng.queue;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

/*给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
        示例 1:
        输入: nums = [1,1,1,2,2,3], k = 2
        输出: [1,2]
        示例 2:
        输入: nums = [1], k = 1
        输出: [1]
        提示：
        你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
        你的算法的时间复杂度必须优于  , n 是数组的大小。
        题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
        你可以按任意顺序返回答案。*/
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        //构造大顶堆，用来处理结果
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(k, (pair1, pair2) -> (pair2[1] - pair1[1]));
        //统计结果
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //队列排序
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.add(new int[]{entry.getKey(), entry.getValue()});
        }
        //构造结果集合
        int[] ans = new int[k];
        for (int i = 0; i< k; i++){
            ans[i] = Objects.requireNonNull(priorityQueue.poll())[0];
        }
        return ans;

    }
}
