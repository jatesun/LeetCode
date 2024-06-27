package com.jatesun.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 * 叶子节点 是指没有子节点的节点。
 * 示例 1：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 * 解释：等于目标和的根节点到叶节点路径如上图所示。
 * 示例 2：
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 * 解释：树中存在两条根节点到叶子节点的路径：
 * (1 --> 2): 和为 3
 * (1 --> 3): 和为 4
 * 不存在 sum = 5 的根节点到叶子节点的路径。
 * 示例 3：
 * 输入：root = [], targetSum = 0
 * 输出：false
 * 解释：由于树是空的，所以不存在根节点到叶子节点的路径。
 * 提示：
 * 树中节点的数目在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
public class HasPathSum_112 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node3.left = node6;
        node3.right = node7;
        node2.left = node4;
        node2.right = node5;
        node5.right = node8;
        HasPathSum_112 hasPathSum_112 = new HasPathSum_112();
        System.out.println(hasPathSum_112.hasPathSum(root, 23));
    }

    /**
     * 本题的解决思路与257很像，将节点与当前节点的路径值同时入栈，迭代的时候同时出栈。
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        Queue<Object> queues = new ArrayDeque<>();
        queues.add(root);
        queues.add(root.val);
        while (!queues.isEmpty()) {
            //出栈
            TreeNode curNode = (TreeNode) queues.poll();
            int curVal = (int) queues.poll();
            if (curNode.left == null && curNode.right == null) {
                //当前为叶节点，判断是否与目标值相同
                if (curVal == targetSum)
                    return true;
            }
            if (curNode.left != null) {
                queues.add(curNode.left);
                queues.add(curVal + curNode.left.val);
            }
            if (curNode.right != null) {
                queues.add(curNode.right);
                queues.add(curVal + curNode.right.val);
            }
        }
        return false;
    }
}
