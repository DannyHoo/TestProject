package com.code.algorithm.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Danny
 * @Title: Solution002
 * @Description:
 * @Created on 2019-02-15 13:24:59
 */
public class Solution002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        ListNode tempNode = l1;
        while (tempNode != null) {
            list1.add(tempNode.val);
            tempNode = tempNode.next;
        }

        tempNode = l2;
        while (tempNode != null) {
            list2.add(tempNode.val);
            tempNode = tempNode.next;
        }

        if (list1.size() < list2.size()) {
            List tempList = list1;
            list1 = list2;
            list2 = tempList;
        }

        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i));
        }
        System.out.println();
        for (int i = 0; i < list2.size(); i++) {
            System.out.print(list2.get(i));
        }

        Map<Integer, Integer> addFlagMap = new HashMap<Integer, Integer>();//进位
        for (int i = list2.size() - 1; i >= 0; i--) {
            int addResult = list1.get(i) + list2.get(i);
            if (addResult >= 10) {
                tempNode.val = addResult % 10;
                addFlagMap.put(i, 1);
            }
            System.out.println(addResult);
        }

        return tempNode;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
