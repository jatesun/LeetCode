package com.jatesun.tree;

import java.util.Arrays;
import java.util.Collections;

/**
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 * <p>
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * 返回 nums 构建的 最大二叉树 。
 * 示例 1：
 * 输入：nums = [3,2,1,6,0,5]
 * 输出：[6,3,5,null,2,0,null,null,1]
 * 解释：递归调用如下所示：
 * - [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
 * - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
 * - 空数组，无子节点。
 * - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
 * - 空数组，无子节点。
 * - 只有一个元素，所以子节点是一个值为 1 的节点。
 * - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
 * - 只有一个元素，所以子节点是一个值为 0 的节点。
 * - 空数组，无子节点。
 * 示例 2：
 * 输入：nums = [3,2,1]
 * 输出：[3,null,2,null,1]
 * <p>
 * 提示：
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 * nums 中的所有整数 互不相同
 */
public class ConstructMaximumBinaryTree_654 {
    public static void main(String[] args) {
        ConstructMaximumBinaryTree_654 constructMaximumBinaryTree_654 = new ConstructMaximumBinaryTree_654();
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode root = constructMaximumBinaryTree_654.constructMaximumBinaryTree(nums);
        LevelOrder_102 levelOrder_102 = new LevelOrder_102();
        System.out.println(levelOrder_102.levelOrder1(root));

    }

    /**
     * 递归的方法，寻找root，处理root，递归处理左右子树
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0)
            return null;
        int curIndex = findMax(nums);
        int[] leftSide = Arrays.copyOfRange(nums, 0, curIndex);//左闭右开
        int[] rightSide = Arrays.copyOfRange(nums, curIndex + 1, nums.length);//左闭右开，去除curindex
        TreeNode root = new TreeNode(nums[curIndex]);
        root.left = constructMaximumBinaryTree(leftSide);
        root.right = constructMaximumBinaryTree(rightSide);
        return root;
    }


    private int findMax(int[] array) {
        int max = array[0];
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                index = i;
            }
        }
        return index;
    }

}
