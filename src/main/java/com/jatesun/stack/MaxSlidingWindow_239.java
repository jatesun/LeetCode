package com.jatesun.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
public class MaxSlidingWindow_239 {
    public static void main(String[] args) {
        MaxSlidingWindow_239 maxSlidingWindow_239 = new MaxSlidingWindow_239();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = maxSlidingWindow_239.maxSlidingWindow1(nums, k);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 暴力解题的思路和简单，首先，计算初始时窗口中的最大值，然后移动，每次移动重新计算最大值。
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];//初始结果
        int left = 0;//起始窗口左侧位置
        int right = k - 1;//起始窗口右侧位置
        while (right < nums.length) {
            int[] cur = Arrays.copyOfRange(nums, left, right + 1);
            int curMax = getMax(cur);
            result[left] = curMax;
            left++;
            right++;
        }
        return result;
    }

    /**
     * 暴力解法超时，我们需要换一个思路。我们可以窗口存入队列，每次入栈出栈进行对比。
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];//初始结果
        Queue<Integer> windowQueue = new ArrayDeque<>();
        int queueMax = nums[0];
        int left = 0;//起始窗口左侧位置
        int right = k - 1;//起始窗口右侧位置
        while (right < nums.length) {
            if (left == 0) {//初始化队列
                queueMax = getQueueMax(nums, windowQueue, queueMax, right);
                result[left] = queueMax;
            } else {//其他情况
                int curVal = nums[right];
                int popVal = windowQueue.poll();
                windowQueue.add(curVal);
                if (curVal > queueMax) {
                    queueMax = curVal;
                    continue;
                } else if (popVal == queueMax) {//正好出栈最大元素，重新寻找
                    windowQueue = new ArrayDeque<>();
                    queueMax = getQueueMax(nums, windowQueue, nums[right], right);
                }
            }
            result[left] = queueMax;
            left++;
            right++;
        }
        return result;
    }

    private int getQueueMax(int[] nums, Queue<Integer> windowQueue, int queueMax, int right) {

        for (int i = 0; i < right + 1; i++) {
            if (nums[i] > queueMax) {
                queueMax = nums[i];
            }
            windowQueue.add(nums[i]);
        }
        return queueMax;
    }


    public int getMax(int[] nums) {
        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > result) {
                result = nums[i];
            }
        }
        return result;
    }
}





















