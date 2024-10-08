package com.jatesun.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * 示例 1：
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 示例 2：
 * <p>
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * 提示：
 * 1 <= n <= 20
 * 1 <= k <= n
 */
public class Combine_77 {
    public static void main(String[] args) {
        Combine_77 combine_77 = new Combine_77();
        combine_77.combine(4, 2);
        System.out.println(combine_77.result);
    }

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    public void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backtracking(n, k, i + 1);
            path.removeLast();//此处为核心的回溯逻辑，假设已有1，2组合，3进去后发现满足return，如果此处没有处理，path还是1，2，
            // 就永远没有其他合适的了，只有把2去掉，继续迭代3，才会有1，3.1，4等组合。需要debug去理解。
        }
    }

    public void backtracking1(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtracking(n, k, i + 1);
            path.removeLast();//此处为核心的回溯逻辑，假设已有1，2组合，3进去后发现满足return，如果此处没有处理，path还是1，2，
            // 就永远没有其他合适的了，只有把2去掉，继续迭代3，才会有1，3.1，4等组合。需要debug去理解。
        }
    }
}
