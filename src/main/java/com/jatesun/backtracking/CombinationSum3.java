package com.jatesun.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * 示例 1:
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 解释:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * 没有其他符合的组合了。
 * 示例 3:
 * <p>
 * 输入: k = 4, n = 1
 * 输出: []
 * 解释: 不存在有效的组合。
 * 在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
 * 提示:
 * <p>
 * 2 <= k <= 9
 * 1 <= n <= 60
 */
public class CombinationSum3 {
    public static void main(String[] args) {
        CombinationSum3 sum3 = new CombinationSum3();
        System.out.println(sum3.combinationSum3(3, 9));
    }

    List<List<Integer>> result = new ArrayList<>();//返回的结果
    LinkedList<Integer> path = new LinkedList<>();//符合结果的单条集合

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 0, 1);
        return result;
    }

    public void backtracking(int k, int n, int sum, int startIndex) {
        //当前逻辑，判断目前path中的和是否满足
        if (path.size() == k && sum == n) {//满足条件
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            sum += i;
            path.add(i);
            backtracking(k, n, sum, i + 1);
            sum -= i;
            path.removeLast();
        }
    }
}

































