package com.jatesun.tree;

/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * 示例 1：
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * 示例 2：
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 * 提示：
 * 树中节点的数目范围是 [2, 104]
 * 0 <= Node.val <= 105
 * 注意：本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
 */
public class GetMinimumDifference_530 {
    /**
     * 本题解题思路很简单，先对root进行判断，然后判断左右子树。
     *
     * @param root
     * @return
     */
    TreeNode pre;// 记录上一个遍历的结点
    int result = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        traversal(root);
        return result;
    }

    public void traversal(TreeNode root) {
        if (root == null) return;
        //左
        traversal(root.left);
        //中
        if (pre != null) {
            result = Math.min(result, root.val - pre.val);
        }
        pre = root;
        //右
        traversal(root.right);
    }
}
