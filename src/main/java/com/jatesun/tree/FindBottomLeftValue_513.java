package com.jatesun.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * 假设二叉树中至少有一个节点。
 * 示例 1:
 * 输入: root = [2,1,3]
 * 输出: 1
 * 示例 2:
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 * 提示:
 * 二叉树的节点个数的范围是 [1,104]
 * -231 <= Node.val <= 231 - 1
 */
public class FindBottomLeftValue_513 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;
        FindBottomLeftValue_513 findBottomLeftValue_513 = new FindBottomLeftValue_513();
        System.out.println(findBottomLeftValue_513.findBottomLeftValue(root));

    }

    /**
     * 可以使用迭代,需要注意的是每一层只要第一个节点的左节点加入结果。
     * fix:刚开始理解错了意思，以为只要最底层的最左侧的节点，其实题目的意思是找到最底层的第一个出现的节点，不分左右。
     */
    public int findBottomLeftValue(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queues = new ArrayDeque<>();
        queues.add(root);
        int result = root.val;//初始
        while (!queues.isEmpty()) {
            int size = queues.size();
            boolean isLeft = false;//用于标记第一个左节点元素。
            while (size > 0) {
                TreeNode node = queues.poll();
                if (node.left != null) {
                    if (isLeft == false) {
                        result = node.left.val;
                        isLeft = true;
                    }
                    queues.add(node.left);
                }
                if (node.right != null) {
                    if (isLeft == false) {
                        result = node.right.val;
                        isLeft = true;
                    }
                    queues.add(node.right);
                }
                size--;
            }
        }
        return result;
    }
}
