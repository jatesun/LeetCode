package com.jatesun.array;


import java.util.Arrays;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * 示例 1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * 提示：
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 * 进阶：
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 */
public class SortedSquares_977 {

    public static void main(String[] args) {
        int[] params = {-7, -3, 2, 3, 11};
        SortedSquares_977 sortedSquares977 = new SortedSquares_977();
//        System.out.println(Arrays.toString(sortedSquares977.sortedSquares(params)));
        System.out.println(Arrays.toString(sortedSquares977.sortedSquares1(params)));
    }

    /**
     * 首先想到的肯定是暴力解法。
     * 1、将数组平方之后排序。
     * 时间复杂度：O(n+nlogn)
     */
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    /**
     * 我们再考虑O(n)的方法
     * 首先我们考虑题目给出的是两边向中间的平方数是越来越小的，所以我们可以维护双指针，逐渐往中间靠近。
     * 1、左指针指向数组左边界，即0.右指针指向数组最右边，即len-1;维护一个结果数组位置指针，默认为最大即len-1;
     * 2、算法结束的标志为左指针=右指针就结束了，但是相等的那次属于边界也要考虑，所以严格来说是左指针>右指针，算法结束。
     * 3、while循环里面，取左右指针的平方数比较大小，分为左边>右边，左边=右边，左边小于右边.写好后可以简化为左边>右边，左边<=右边。
     * 4、如果左边<=右边。最大的结果为右边平方数，结果位置指针-1，右指针-1（向左移动一位）
     * 5、如果左边>右边。最大结果为左边平方数，结果指针-1，左指针+1；
     */
    public int[] sortedSquares1(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int pos = nums.length - 1;
        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            if (leftSquare <= rightSquare) {
                result[pos] = rightSquare;
                right--;
            } else {
                result[pos] = leftSquare;
                left++;
            }
            pos--;
        }
        return result;
    }


}
