package com.jatesun.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * 提示：
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class InorderTraversal_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        innerInorder(root, result);
        return result;
    }

    public void innerInorder(TreeNode cur, List<Integer> result) {
        if (cur == null) return;
        //中序遍历，先遍历左，再中，在右。
        innerInorder(cur.left, result);
        result.add(cur.val);
        innerInorder(cur.right, result);
    }

}
