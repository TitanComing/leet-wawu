package org.peng.HashTable;

/*给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

        你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

        示例:

        给定 nums = [2, 7, 11, 15], target = 9

        因为 nums[0] + nums[1] = 2 + 7 = 9

        所以返回 [0, 1]*/

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }
        int[] result = new int[2];
        //1. map可以去重； 2. map可以提高查询效率，直接获取需要的值，而不是遍历 3.map中的key存数组的值，value存数组的索引
        Map<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (record.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = record.get(target - nums[i]);
            } else {
                record.put(nums[i], i);
            }
        }

        return result;
    }
}
