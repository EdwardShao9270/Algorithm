package com.sh.offer.linkedlist;

import java.util.ArrayList;

/**
 * @Auther: bjshaohang
 * @Date: 2019/1/30
 */
public class MergeListNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(5);
        ListNode d = new ListNode(7);
        ListNode e = new ListNode(9);
        head.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode head1 = new ListNode(2);
        ListNode b1 = new ListNode(4);
        ListNode c1 = new ListNode(6);
        ListNode d1 = new ListNode(8);
        ListNode e1 = new ListNode(10);
        head1.next = b1;
        b1.next = c1;
        c1.next = d1;
        d1.next = e1;
       // ListNode result1  = new MergeListNode().Merge(head,head1);
        ListNode result1  = new MergeListNode().recursive(head,head1);

        new  MergeListNode().printLink(result1);
    }


    public  ListNode recursive(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode head = null;
        if(list1.val < list2.val){
            head = list1;
            head.next = recursive(list1.next,list2);
        }else {
            head = list2;
            head.next = recursive(list1,list2.next);
        }
        return head;

    }

        public  ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null && list2 !=null ){
            return list2;
        }
        if (list1 == null && list2 == null){
            return null;
        }
        if(list1 !=null && list2 == null){
            return list1;
        }

        ListNode head;
        if(list1.val >= list2.val){
            head = list2;
            list2 = list2.next;
        }else {
            head = list1;
            list1 = list1.next;
        }
        ListNode curNode = head;
        while (list1 !=null && list2 != null){
            if(list1.val >= list2.val){
                curNode.next = list2;
                list2 = list2.next;

            }else {
                curNode.next = list1;
                list1 = list1.next;

            }
            curNode = curNode.next;

        }

        while (list1 != null){
            curNode.next = list1;
            list1 = list1.next;
            curNode = curNode.next;
        }
        while (list2 != null){
            curNode.next = list2;
            list2 = list2.next;
            curNode = curNode.next;
        }

        return head;
    }

    public  void printLink(ListNode head){
        ListNode curNode = head;
        while(curNode !=null){
            System.out.print(curNode.val+" ");
            curNode = curNode.next;
        }
        System.out.println();
    }
}
