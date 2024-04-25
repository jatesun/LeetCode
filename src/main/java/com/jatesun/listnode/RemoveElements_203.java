package com.jatesun.listnode;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 * 提示：
 * 列表中的节点数目在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 */
public class RemoveElements_203 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node5.next = node6;
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        RemoveElements_203 removeElements203 = new RemoveElements_203();
        ListNode result = removeElements203.removeElements(head, 6);
        removeElements203.printNode(result);
    }

    public void printNode(ListNode node) {
        while (true) {
            if (node == null) {
//                System.out.println("无元素，跳出循环");
                break;
            } else if (node.next == null) {
                System.out.println(node.val);
                node = node.next;
            } else {
                System.out.println(node.val);
                node = node.next;
            }
        }
    }

    /**
     * 思路比较简单，但是要注意边界的情况
     * 1、head为null直接返回null
     * 2、head只有一个，需要单独处理，val相同且resultnode为null返回null，否则返回resultnode
     * 3、head.next有，val相等删除当前节点，否则继续移动，给resultnode合理赋值。
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode resultNode = null;
        ListNode curNode = head;
        ListNode prevNode = head;
        if (head == null)
            return null;
        while (true) {
            if (curNode.next == null) {//说明是最后的元素了。
                if (curNode.val == val) {//val相等
                    if (resultNode == null) {//resultnode还没赋值
                        return null;
                    } else {
                        prevNode.next = null;
                        return resultNode;
                    }
                } else {
                    if (resultNode == null) {
                        resultNode = curNode;
                    }
                    return resultNode;
                }
            } else {
                int curVal = curNode.val;
                if (curVal == val) {//相等删除当前节点，
//                    if (resultNode == null) {//result没有赋值就跟着移动，赋值了就之移动nextnode。
//                        resultNode = curNode;
//                    }
                    prevNode.next = curNode.next;
                    curNode = curNode.next;
                } else {//不相等仅移动nextnode
                    if (resultNode == null) {
                        resultNode = curNode;
                    }
                    prevNode = curNode;
                    curNode = curNode.next;
                }
            }
        }
    }
}
