package com.jatesun.tree;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * 示例 2：
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 * 提示：
 * 树中节点数目范围在 [0, 100] 内
 * -100 <= Node.val <= 100
 */
public class InvertTree_226 {
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
        LevelOrder_102 levelOrder_102 = new LevelOrder_102();
        System.out.println(levelOrder_102.levelOrder1(root));
        InvertTree_226 invertTree_226 = new InvertTree_226();
        invertTree_226.invertTree(root);
        System.out.println(levelOrder_102.levelOrder1(root));
    }

    /**
     * 可以使用递归的方法，
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        swap(root);
        return root;
    }

    public void swap(TreeNode node) {
        if (node == null)
            return;
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        swap(node.left);
        swap(node.right);
    }
}
