package com.jatesun.array;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。找出该数组中满足其总和大于等于 target 的长度最小的连续子数组
 * [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * 提示：
 * 1 <= target <= 10的9次方
 * 1 <= nums.length <= 10的5次方
 * 1 <= nums[i] <= 10的5次方
 * 进阶：
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 */
public class MinSubArrayLen_209 {
    public static void main(String[] args) {
        //使用leetcode中给出的十万测试用例，n2的执行时间为1272ms，n的执行时间为2ms。
        //给出了自己从n3——>n2——>n的历程。
        MinSubArrayLen_209 minSubArrayLen209 = new MinSubArrayLen_209();
//        int[] nums = {2, 3, 1, 2, 4, 3};
//        int[] nums = {1, 4, 4};
//        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1};
        int[] nums = {1, 2, 3, 4, 5};
        long curTime = System.currentTimeMillis();
        System.out.println(minSubArrayLen209.minSubArrayLen2(396893380, nums));
        System.out.println("程序耗费时间：" + (System.currentTimeMillis() - curTime));
    }


    /**
     * 首先想到的肯定是暴力解法，将所有组合的情况列出来，比如数组长度为5.将组合1-5都列出来，穷举法。
     * 此方法的时间复杂度为O(n3)，效率极低。不出意料，放在leetcode上超时了。
     */
    public int minSubArrayLen(int target, int[] nums) {
        int result = 0;
        for (int i = 1; i <= nums.length; i++) {//从长度为1开始穷举
            for (int j = 0; j < (nums.length - i + 1); j++) {//穷举
                int inner = 0;
                for (int k = 0; k < i; k++) {
                    inner += nums[j + k];
                }
                if (inner >= target) {
                    if (result == 0 | i < result) {
                        result = i;
                    }
                }
            }
        }
        return result;
    }

    /**
     * 上面的暴力解法实现不好，针对的是每次都要遍历全部的数的子数组，其实不用向前遍历，只需要向后遍历即可。
     * 此方法的时间复杂度为O(n2)，在leetcode超时。
     */
    public int minSubArrayLen1(int target, int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {//从0开始计算子序列
            int sum = 0;
            for (int j = i; j < nums.length; j++) {//计算子序列终止，从数组有1个元素开始，到数组整个的长度
                sum += nums[j];
                if (sum >= target) {
                    int length = j - i + 1;
                    if (result == 0 | length < result) {
                        result = length;
                    }
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 滑动窗口实现。
     * 原理其实也是双指针，一个指针在起始位置，一个从起始位置开始移动，直到满足区间和>=target停止。（如果找到最后也没找到为0）
     * 1、在和>=target时，右指针不动，左指针往前移动，直至sum<target。我们需要记录sum>=target的时候窗口大小。
     * 2、结束判定是左指针追上了右指针。
     * 时间复杂度：O(n+n)
     */
    public int minSubArrayLen2(int target, int[] nums) {
        int result = 0;//结果的窗口大小.
        int left = 0;
        int right = 0;//左右指针起始
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];//求和
            if (curSum >= target) {//如果符合
                right = i;//指针移动；
                //给结果赋值
                if (result == 0 | (right + 1) < result) {
                    result = right + 1;
                }
                //左指针也需要移动,结束的标志是左指针追上了右指针
                while (left < right) {
                    curSum -= nums[left];//和要减去移动的位置
                    if (curSum >= target) {
                        left++;
                        if (result == 0 | (right - left + 1) < result) {
                            result = right - left + 1;
                        }
                    } else {
                        left++;
                        break;//如果小于目标值需要跳出while循环。
                    }

                }
            } else {//不符合
                right = i;//右指针移动
            }
        }
        return result;
    }


}
