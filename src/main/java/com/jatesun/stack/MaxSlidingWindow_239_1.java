package com.jatesun.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class MaxSlidingWindow_239_1 {
    public static void main(String[] args) {
        MaxSlidingWindow_239_1 maxSlidingWindow_239_1 = new MaxSlidingWindow_239_1();
//        int[] nums = {1, -1};
//        int k = 1;
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = maxSlidingWindow_239_1.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 暴力解法超时，我们需要换一个思路。我们可以窗口存入队列，每次入栈出栈进行对比。
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];//初始结果
        Queue<Integer> windowQueue = new ArrayDeque<>();
        int queueMax = nums[0];
        int left = 0;//起始窗口左侧位置
        int right = k - 1;//起始窗口右侧位置
        while (right < nums.length) {
            if (left == 0) {//初始化队列
                queueMax = getQueueMax(nums, windowQueue, queueMax, right, left);
            } else {//其他情况
                int curVal = nums[right];
                int popVal = windowQueue.poll();
                windowQueue.add(curVal);
                if (curVal > queueMax) {
                    queueMax = curVal;
                    continue;
                } else if (popVal == queueMax) {//正好出栈最大元素，重新寻找
                    windowQueue = new ArrayDeque<>();
                    queueMax = getQueueMax(nums, windowQueue, nums[right], right, left);

                }
            }
            result[left] = queueMax;
            left++;
            right++;
        }
        return result;
    }


    private int getQueueMax(int[] nums, Queue<Integer> windowQueue, int queueMax, int right, int left) {

        for (int i = left; i < right + 1; i++) {
            if (nums[i] > queueMax) {
                queueMax = nums[i];
            }
            windowQueue.add(nums[i]);
        }
        return queueMax;
    }

}
