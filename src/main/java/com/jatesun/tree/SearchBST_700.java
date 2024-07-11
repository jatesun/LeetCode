package com.jatesun.tree;

/**
 * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 * 示例 1:
 * 输入：root = [4,2,7,1,3], val = 2
 * 输出：[2,1,3]
 * 示例 2:
 * 输入：root = [4,2,7,1,3], val = 5
 * 输出：[]
 * 提示：
 * 树中节点数在 [1, 5000] 范围内
 * 1 <= Node.val <= 107
 * root 是二叉搜索树
 * 1 <= val <= 107
 */
public class SearchBST_700 {

    /**
     * 完成这道题我们需要知道二叉搜索数的特点。二叉搜索树的特点是左节点的值<当前节点<右节点的值。
     * 所以我们可以递归判断，当前节点是否==目标值 返回，大于目标值 搜索右子树，小于目标值搜索左子树。
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;
        int curVal = root.val;
        if (curVal == val) {
            return root;
        } else if (curVal > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
