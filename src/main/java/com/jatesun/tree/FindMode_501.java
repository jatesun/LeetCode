package com.jatesun.tree;

import java.util.*;

/**
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 * 假定 BST 满足如下定义：
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 * 示例 1：
 * 输入：root = [1,null,2,2]
 * 输出：[2]
 * 示例 2：
 * 输入：root = [0]
 * 输出：[0]
 * 提示：
 * 树中节点的数目在范围 [1, 104] 内
 * -105 <= Node.val <= 105
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 */
public class FindMode_501 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        root.right = node1;
        node1.left = node2;
        FindMode_501 findMode_501 = new FindMode_501();
        System.out.println(Arrays.toString(findMode_501.findMode(root)));
    }

    /**
     * 可以使用迭代法。
     */
    public int[] findMode(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int maxRep = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            Integer curValueCount = countMap.get(cur.val);
            if (Objects.isNull(curValueCount) || curValueCount == 0)
                curValueCount = 0;
            curValueCount++;
            if (curValueCount >= maxRep)
                maxRep = curValueCount;
            countMap.put(cur.val, curValueCount);
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
        List<Integer> result = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == maxRep) {
                result.add(entry.getKey());
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
