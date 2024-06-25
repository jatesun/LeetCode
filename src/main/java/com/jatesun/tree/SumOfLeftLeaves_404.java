package com.jatesun.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 * 示例 1：
 * 输入: root = [3,9,20,null,null,15,7]
 * 输出: 24
 * 解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * 示例 2:
 * 输入: root = [1]
 * 输出: 0
 * 提示:
 * 节点数在 [1, 1000] 范围内
 * -1000 <= Node.val <= 1000
 */
public class SumOfLeftLeaves_404 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        SumOfLeftLeaves_404 sumOfLeftLeaves_404 = new SumOfLeftLeaves_404();
        System.out.println(sumOfLeftLeaves_404.sumOfLeftLeaves(root));

    }

    /**
     * 迭代
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        int result = 0;
        Queue<TreeNode> queues = new ArrayDeque<>();
        queues.add(root);
        while (!queues.isEmpty()) {
            TreeNode cur = queues.poll();
            if (cur.left != null) {
                if (cur.left.left == null && cur.left.right == null) {
                    result += cur.left.val;
                }
                queues.add(cur.left);
            }
            if (cur.right != null)
                queues.add(cur.right);
        }
        return result;
    }
}
