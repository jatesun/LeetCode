package com.jatesun.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你两棵二叉树： root1 和 root2 。
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 * 返回合并后的二叉树。
 * 注意: 合并过程必须从两个树的根节点开始。
 * 示例 1：
 * 输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * 输出：[3,4,5,5,4,null,7]
 * 示例 2：
 * 输入：root1 = [1], root2 = [1,2]
 * 输出：[2,2]
 * 提示：
 * 两棵树中的节点数目在范围 [0, 2000] 内
 * -104 <= Node.val <= 104
 */
public class MergeTrees_617 {
    /**
     * 合并两棵树，递归很容易写出来
     * 递归的技巧：递归的技巧在于你只需要专注于当前的操作，比如合并两个数，你就考虑合并两个节点，假设根节点，然后延展就可以了。
     * 用在这里，我们就合并当前的两个根节点，如果某个为空返回另外一个。否则合并，合并之后需要递归合并左右子树。
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        queue.offer(root2);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            // 此时两个节点一定不为空，val相加
            node1.val = node1.val + node2.val;
            // 如果两棵树左节点都不为空，加入队列
            if (node1.left != null && node2.left != null) {
                queue.offer(node1.left);
                queue.offer(node2.left);
            }
            // 如果两棵树右节点都不为空，加入队列
            if (node1.right != null && node2.right != null) {
                queue.offer(node1.right);
                queue.offer(node2.right);
            }
            // 若node1的左节点为空，直接赋值
            if (node1.left == null && node2.left != null) {
                node1.left = node2.left;
            }
            // 若node1的右节点为空，直接赋值
            if (node1.right == null && node2.right != null) {
                node1.right = node2.right;
            }
        }
        return root1;
    }
}
