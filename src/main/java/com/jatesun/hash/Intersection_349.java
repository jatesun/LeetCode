package com.jatesun.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定两个数组 nums1 和 nums2 ，返回 它们的
 * 交集
 * 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 * 提示：
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 */
public class Intersection_349 {
    public static void main(String[] args) {
        int[] num1 = {4, 9, 5};
        int[] num2 = {9, 4, 9, 8, 4};
        Intersection_349 intersection349 = new Intersection_349();
        int[] result = intersection349.intersection(num1, num2);
        for (int i : result) {
            System.out.println(i);
        }

    }

    /**
     * 本题解题很容易就可以想到n2的算法.
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();
        for (int i : nums1) {
            for (int j : nums2) {
                if (i == j) {
                    result.add(j);
                }
            }
        }
        return Arrays.stream(result.stream().toArray(Integer[]::new)).mapToInt(Integer::valueOf).toArray();
    }


}
