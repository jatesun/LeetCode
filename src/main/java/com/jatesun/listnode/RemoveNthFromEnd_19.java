package com.jatesun.listnode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 示例1
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * 提示：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class RemoveNthFromEnd_19 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
//        ListNode node2 = new ListNode(3);
//        ListNode node3 = new ListNode(4);
//        ListNode node4 = new ListNode(5);
//        head.next = node1;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
        RemoveNthFromEnd_19 removeNthFromEnd19 = new RemoveNthFromEnd_19();
        ListNode node = removeNthFromEnd19.removeNthFromEnd(head, 1);
    }

    /**
     * 本题的解题关键在于找到要删除的节点。可以使用类似滑动窗口的思想来解决本题。
     * 首先维护一个n大小的窗口，滑动寻找，直到找到最后一个元素。
     * 此时n窗口的第一个元素就是要删除的元素。（我们要维护这第一个元素的前一个node）
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //先写一般、再写特殊
        ListNode vitualHead = new ListNode(-1);//虚拟头节点
        vitualHead.next = head;
        ListNode nodeToDelete = head;//要删除的节点,默认head
        ListNode preNode = vitualHead;//删除节点的前节点,默认虚拟节点
        ListNode curNode = head;//当前节点
        if (head == null | (head.next == null && n == 1)) {//处理特殊情况
            return null;
        }
        while (curNode != null) {
            if (n <= 0) {
                nodeToDelete = nodeToDelete.next;
                preNode = preNode.next;
            }
            n--;
            curNode = curNode.next;
        }
        if (nodeToDelete != null) {//如果找到要删除的节点
            preNode.next = nodeToDelete.next;
        }
        return vitualHead.next;
    }
}
