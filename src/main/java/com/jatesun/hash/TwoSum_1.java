package com.jatesun.hash;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * 提示：
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 */
public class TwoSum_1 {
    public static void main(String[] args) {
        TwoSum_1 twoSum_1 = new TwoSum_1();
        int[] nums = {3, 3};
        int target = 6;
        int[] result = twoSum_1.twoSum(nums, target);
        for (int i : result) {
            System.out.println(i);
        }

    }

    /**
     * 显而易见的方法是双层变量数组，因为题目中已经给出了只有两个整数，那么只要双层for循环就可以找出答案
     * 时间复杂度：显而易见为O2.
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (j >= nums.length) {
                    break;
                }
                int curSum = nums[i] + nums[j];
                if (curSum == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    /**
     * 我们通过题目可以得到数组肯定存在两个数等于target。所以我们对数组先排序后查找， 这样的时间复杂度为nlogn
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        List<Integer> lists = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(lists);
        for (int i = 0; i < lists.size(); i++) {
            //二分查找内部的数据
        }
        return null;
    }
}
