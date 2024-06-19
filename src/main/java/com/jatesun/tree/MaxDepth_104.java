package com.jatesun.tree;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

/**
 * 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：3
 * 示例 2：
 * 输入：root = [1,null,2]
 * 输出：2
 * 提示：
 * 树中节点的数量在 [0, 104] 区间内。
 * -100 <= Node.val <= 100
 */
public class MaxDepth_104 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(9);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        MaxDepth_104 maxDepth_104 = new MaxDepth_104();
        System.out.println(maxDepth_104.maxDepth(root));
    }

    /**
     * 可以层序遍历，每层+1；
     * 此方法为迭代法。
     */
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queues = new ArrayDeque<>();
        if (root == null)
            return 0;
        queues.add(root);
        int maxDepth = 0;
        while (!queues.isEmpty()) {
            int curLevel = queues.size();
            maxDepth++;
            while (curLevel > 0) {
                TreeNode currentNode = queues.poll();
                if (!Objects.isNull(currentNode.left))
                    queues.add(currentNode.left);
                if (!Objects.isNull(currentNode.right))
                    queues.add(currentNode.right);
                curLevel--;
            }
        }
        return maxDepth;
    }

    /**
     * 递归方法
     */
    public int maxDepth1(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = maxDepth1(root.left);
        int rightDepth = maxDepth1(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
