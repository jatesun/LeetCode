package com.jatesun.array;

/**
 * 题目描述：
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * 示例 1:
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * 提示：
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 */
public class BinaryFind_704 {
    public static void main(String[] args) {

    }

    /**
     * 初次解题思路
     * 首先肯定是折半查找。需要三个位置，初始位置为startPos(0)，mid，endPos(数组长度)。
     * 1、比较mid是否与target相等，相等返回下标
     * 2、如果mid比target小，那么就应该继续在数组左边查找，将endPos设置为mid，将mid设置为新。
     * 3、如果mid比target大，那么应该在数组右边查找，startPos设置为mid，mid设置为新。
     * 判定结束
     * 1、因为是折半，mid最终会与start值一样，说明没有未查找的数字了，返回-1
     * 2、特殊情况：如果数组只有一个数，且为目标值，需要特殊判断。
     * 时间复杂度
     * 1、大家都能想到的for循环的时间复杂度为O(n)
     * 2、折半的时间复杂度为O(logn)
     */
    public int search(int[] nums, int target) {
        int startPos = 0;
        int endPos = nums.length;
        int mid = (endPos + startPos) / 2;
        while (true) {
            if (startPos == mid) {
                if (nums[mid] == target) {//该段判断是提交后特殊情况加上的判断，数组只有一个数字5，且target为5
                    return mid;
                }
                break;
            }
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                endPos = mid;
                mid = (endPos + startPos) / 2;//更换值自测时第一遍没有更换，测试debug后发现，调整。
            } else {
                startPos = mid;
                mid = (startPos + endPos) / 2;
            }

        }
        return -1;
    }

}
