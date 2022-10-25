package org.peng.HashTable;

/*题意：给定两个数组，编写一个函数来计算它们的交集。*/

import java.util.HashSet;
import java.util.Set;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> temp = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for (int num : nums1) {
            temp.add(num);
        }
        for (int num : nums2) {
            if (temp.contains(num)) {
                result.add(num);
            }
        }
        return result.stream().mapToInt(num -> num).toArray();
    }
}
