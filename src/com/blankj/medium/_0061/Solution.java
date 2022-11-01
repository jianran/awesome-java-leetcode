package com.blankj.medium._061;


import com.blankj.structure.ListNode;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode listNode = ListNode.createTestData("[1,2,3,4,5]");
        ListNode.print(s.rotate(listNode, 2));
        listNode = ListNode.createTestData("[0,1,2]");
        ListNode.print(s.rotate(listNode, 4));
    }

    public ListNode rotate(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }

        int length = 1;
        ListNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
            length++;
        }
        ListNode end = tmp;
        tmp = head;
        for (int i = 0; i < length - k % length - 1; i++) {
            tmp = tmp.next;
        }
        end.next = head;
        head = tmp.next;
        tmp.next = null;
        return head;
    }
}
