package com.jatesun.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * 示例 1：
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 * 示例 2：
 * 输入：root = []
 * 输出：0
 * 示例 3：
 * 输入：root = [1]
 * 输出：1
 * 提示：
 * 树中节点的数目范围是[0, 5 * 104]
 * 0 <= Node.val <= 5 * 104
 * 题目数据保证输入的树是 完全二叉树
 * 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？
 */
public class CountNodes_222 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        CountNodes_222 countNodes_222 = new CountNodes_222();
        System.out.println(countNodes_222.countNodes(root));

    }

    /**
     * 最简单的方法为迭代
     */
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queues = new ArrayDeque<>();
        queues.add(root);
        int totalCount = 0;
        while (!queues.isEmpty()) {
            int curLevel = queues.size();
            totalCount += curLevel;
            while (curLevel > 0) {
                TreeNode curNode = queues.poll();
                if (curNode.left != null)
                    queues.add(curNode.left);
                if (curNode.right != null)
                    queues.add(curNode.right);
                curLevel--;
            }
        }
        return totalCount;
    }

    /**
     * 递归方法
     * 递归的代码很简单，但是往往比较难以想到。针对每个节点都是判断当前节点是否为空，如果空return 0.不为空，返回左右子树的个数+当前节点1.
     */
    public int countNodes1(TreeNode root) {
        if (root == null)
            return 0;
        return countNodes1(root.left) + countNodes1(root.right) + 1;
    }
}
























