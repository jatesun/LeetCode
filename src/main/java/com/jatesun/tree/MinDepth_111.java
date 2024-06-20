package com.jatesun.tree;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 * 提示：
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 */
public class MinDepth_111 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        node1.left = node2;
        node2.left = node3;
        node3.left = node4;
        MinDepth_111 minDepth_111 = new MinDepth_111();
        System.out.println(minDepth_111.minDepth(root));
    }

    /**
     * 首先我们先考虑迭代法。迭代的思路比较容易想。
     * 1、我们首先要确定结束的条件，结束的条件为如果一个节点的左右节点都为null，那么当前节点所在的深度就是最小深度。（注意）
     */
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queues = new ArrayDeque<>();
        queues.add(root);
        int minDepth = 0;
        while (!queues.isEmpty()) {
            int curLevel = queues.size();
            ++minDepth;
            while (curLevel > 0) {
                TreeNode curNode = queues.poll();
                if (curNode.left == null & curNode.right == null) {
                    return minDepth;
                } else {
                    if (!Objects.isNull(curNode.left))
                        queues.add(curNode.left);
                    if (!Objects.isNull(curNode.right))
                        queues.add(curNode.right);
                }
                curLevel--;
            }
        }
        return minDepth;
    }
}






















