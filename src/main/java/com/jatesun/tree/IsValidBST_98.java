package com.jatesun.tree;

import java.util.Stack;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * 节点的左
 * 子树
 * 只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1：
 * 输入：root = [2,1,3]
 * 输出：true
 * 示例 2：
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 * 提示：
 * 树中节点数目范围在[1, 104] 内
 * -231 <= Node.val <= 231 - 1
 */
public class IsValidBST_98 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        IsValidBST_98 isValidBST_98 = new IsValidBST_98();
        System.out.println(isValidBST_98.isValidBST(root));
    }

    /**
     * 我们很容易得出递归的步骤，比较root，然后递归比较root的左右子树
     */
    // 递归
    TreeNode max;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 左
        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }
        // 中
        if (max != null && root.val <= max.val) {
            return false;
        }
        max = root;
        // 右
        boolean right = isValidBST(root.right);
        return right;
    }

    /**
     * 迭代
     */
    public boolean isValidBST1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        if (root != null)
            stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            if (curr != null) {
                stack.pop();
                if (curr.right != null)
                    stack.add(curr.right);
                stack.add(curr);
                stack.add(null);
                if (curr.left != null)
                    stack.add(curr.left);
            } else {
                stack.pop();
                TreeNode temp = stack.pop();
                if (pre != null && pre.val >= temp.val)
                    return false;
                pre = temp;
            }
        }
        return true;
    }
}
