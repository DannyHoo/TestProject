package com.code.algorithm.interview;

import java.util.ArrayList;

/**
 * 输入一个链表，输出该链表中倒数第k个结点
 * https://blog.csdn.net/qq_28081081/article/details/80761353
 */
public class FindTheLastKNode {

    /**
     * 思路一：
     * 要得到这个倒数第k个节点的,首先遍历这个这个链表，遍历的同时将这个链表放入到一个ArrayList<ListNode>中然后要取这个倒数第k个这个时候只需要求倒数第k的下标就可以了。
     * 缺陷：这个主要是在当我这个链表的长度很长的时候这个会导致用一个ArrayList存储的时候造成很大的空间使用。
     * 如果是要长期查询倒数第几个则可以使用这种方式。
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail1(ListNode head, int k) {
        ArrayList<ListNode> nodeList = new ArrayList<ListNode>();
        while (head != null) {
            nodeList.add(head);
            head = head.next;
        }
        int length = nodeList.size();
        if (k > length || k <= 0) {
            return null;
        }
        return nodeList.get(length - k);
    }

    public static class ListNode {
        String value;
        ListNode next;
    }

    /**
     * 思路二：
     * 两个指针，先让第一个指针和第二个指针都指向头结点，然后再让第一个指正走(k-1)步，到达第k个节点。然后两个指针同时往后移动，当第一个结点到达末尾的时候，第二个结点所在位置就是倒数第k个节点了。
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail2(ListNode head, int k) {
        if (k <= 0 || head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode last = head;
        for (int i = 1; i < k; i++) {
            if (last.next != null) {
                last = last.next;
            } else {
                return null;
            }
        }
        while (last.next != null) {
            pre = pre.next;
            last = last.next;
        }
        return pre;
    }
}
