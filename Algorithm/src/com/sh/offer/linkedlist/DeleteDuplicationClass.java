package com.sh.offer.linkedlist;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: bjshaohang
 * @Date: 2019/3/13
 */
public class DeleteDuplicationClass {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(2);
        ListNode f = new ListNode(3);
        ListNode g = new ListNode(5);

        String s = "abcd";
        System.out.println(s.charAt(1));

        head.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;

        ListNode result = new DeleteDuplicationClass().deleteDuplication(head);
        new  MergeListNode().printLink(result);

    }

    public ListNode deleteDuplication(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        if(cur.val == cur.next.val){
            while(cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
            }
            return deleteDuplication(cur.next);
        }else{
            cur.next = deleteDuplication(cur.next);
            return cur;
        }
    }

}
