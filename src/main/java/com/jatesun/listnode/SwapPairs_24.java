package com.jatesun.listnode;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * 示例1
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 * 提示：
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 */
public class SwapPairs_24 {
    /**
     * 思路
     * 1、首先对head进行判断，如果head为null或者只有一个直接返回
     * 2、取当前节点、当前节点的next。
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dumyhead = new ListNode(-1); // 设置一个虚拟头结点
        dumyhead.next = head; //
        ListNode cur = dumyhead;
        ListNode temp; // 临时节点
        ListNode firstnode; // 临时节点，两个节点之中的第一个节点
        ListNode secondnode; // 临时节点，两个节点之中的第二个节点
        while (cur.next != null && cur.next.next != null) {
            temp = cur.next.next.next;
            firstnode = cur.next;
            secondnode = cur.next.next;
            cur.next = secondnode;       // 更换节点
            secondnode.next = firstnode;
            firstnode.next = temp;
            cur = firstnode;
        }
        return dumyhead.next;
    }
}
