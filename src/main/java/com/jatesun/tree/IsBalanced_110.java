package com.jatesun.tree;

/**
 * 给定一个二叉树，判断它是否是
 * 平衡二叉树
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * 示例 2：
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * 示例 3：
 * 输入：root = []
 * 输出：true
 * 提示：
 * 树中的节点数在范围 [0, 5000] 内
 * -104 <= Node.val <= 104
 */
public class IsBalanced_110 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node3.left = node5;
        node3.right = node6;


        IsBalanced_110 isBalanced_110 = new IsBalanced_110();
        System.out.println(isBalanced_110.isBalanced(root));
    }


    /**
     * 首先我们可以明确如何判断是平衡二叉树，我门可以得出这样的结论：根节点的左子树与右子树的差大于1，且每个子子树都满足这样的性质。
     * 所以我们可以得出这样的算法逻辑：
     * 1、获取根节点左右子树的高度，比较是否满足，不满足直接false
     * 2、如果满足我们需要递归根节点的左右节点的左右高度是否满足，一直迭代到最后。
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return innerBalanced(root);
    }

    public boolean innerBalanced(TreeNode node) {
        int left = getDepth(node.left);
        int right = getDepth(node.right);
        if (left - right <= 1 && left - right >= -1) {
            return isBalanced(node.left) && isBalanced(node.right);
        } else {
            return false;
        }
    }

    private int getDepth(TreeNode node) {
        if (node == null)
            return 0;
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
