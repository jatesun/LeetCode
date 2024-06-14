package com.jatesun.tree;

import java.util.*;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * 示例 2：
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 * 提示：
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 */
public class LevelOrder_102 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        LevelOrder_102 levelOrder_102 = new LevelOrder_102();
        levelOrder_102.levelOrder(root);
    }

    /**
     * 最初想法：
     * 最初的想法是放到队列或者栈，进来一个节点将当前节点存入，然后将子元素存入。但是缺少下面的思路
     * 提示后思路:
     * 查阅的提示，思路为
     * 1.将root放入一个队列中，
     * 2.遍历队列，获取元素，将当前元素放入list，如果有左右节点，放入队列
     * 3.遍历list，每层大小指定，1，2，4，8
     * 但是这样null元素存不到list中，for循环出现问题
     * 修改：
     * 可以再while循环加入当前层级的判断，当前层级的判断其实就是当前queque是否空了，在保存一个变量判断
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (Objects.isNull(root))
            return Collections.EMPTY_LIST;
        Queue<TreeNode> queues = new ArrayDeque<>();
        queues.add(root);
        List<Integer> list = new ArrayList<>();
        //开始迭代
        while (!queues.isEmpty()) {
            TreeNode currentNode = queues.poll();
            list.add(currentNode.val);
            if (!Objects.isNull(currentNode.left))
                queues.add(currentNode.left);
            if (!Objects.isNull(currentNode.right))
                queues.add(currentNode.right);
        }
        //迭代完成，开始遍历list
        int currentLevel = 0;
        int levelNum = 1;
        int curNum = 0;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> innerResult = new ArrayList<>();
        for (Integer i : list) {
            innerResult.add(list.get(i));
            curNum++;
            //判断是否需要加入最后的结果
            if (curNum == levelNum) {
                result.add(innerResult);
                innerResult = new ArrayList<>();
                currentLevel++;
                levelNum = 1 << currentLevel;
                curNum = 0;
            }
        }
        return result;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (Objects.isNull(root))
            return Collections.EMPTY_LIST;
        Queue<TreeNode> queues = new ArrayDeque<>();
        queues.add(root);
        List<List<Integer>> result = new ArrayList<>();
        //开始迭代
        while (!queues.isEmpty()) {
            List<Integer> inner = new ArrayList<>();
            int curlevel = queues.size();
            while (curlevel > 0) {
                TreeNode currentNode = queues.poll();
                inner.add(currentNode.val);
                if (!Objects.isNull(currentNode.left))
                    queues.add(currentNode.left);
                if (!Objects.isNull(currentNode.right))
                    queues.add(currentNode.right);
                curlevel--;
            }
            result.add(inner);

        }
        return result;
    }


}























