package com.jatesun.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」 定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * 示例 1：
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 示例 2：
 * 输入：n = 2
 * 输出：false
 * 提示：
 * 1 <= n <= 231 - 1
 */
public class IsHappy_202 {
    public static void main(String[] args) {
        IsHappy_202 isHappy202 = new IsHappy_202();
        boolean result = isHappy202.isHappy(9);
        System.out.println(result);
    }

    /**
     * 给定的n有可能会无线循环，所以要保存每次计算后的结果然后对比，如果存在就不是快乐数
     */
    public boolean isHappy(int n) {
        Set<Integer> preNums = new HashSet<>();
        int cur = n;
        while (!preNums.contains(cur)) {
            if (cur == 1) {
                return true;
            }
            preNums.add(cur);
            //计算平方和的数.
            cur = getSquares(cur);

        }
        return false;
    }

    /**
     * 根据n计算平方和，然后返回
     */
    private int getSquares(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }
}
