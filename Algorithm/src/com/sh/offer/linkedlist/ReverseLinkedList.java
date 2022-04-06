package com.sh.offer.linkedlist;

/**
 * @Auther: bjshaohang
 * @Date: 2019/1/30
 */
public class ReverseLinkedList {
    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode curNode = head;
        ListNode preNode = null;
        while(curNode != null){
            ListNode nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }
}
