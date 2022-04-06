package com.sh.leetcode.linklist;

import com.sh.offer.linkedlist.ListNode;
import com.sh.offer.linkedlist.MergeListNode;

import java.util.Stack;

/**
 * @Auther: bjshaohang
 * @Date: 2019/3/21
 */
public class AddTwoNums2 {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(2);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);

        head1.next = b;
        b.next = c;

        ListNode head2 = new ListNode(5);
        ListNode d = new ListNode(6);
        ListNode e = new ListNode(4);

        head2.next = d;
        d.next = e;

        ListNode result = new AddTwoNums2().addTwoNumbers(head1,head2);

        new MergeListNode().printLink(result);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return null;
        }
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int len1 = 0;
        while(cur1 != null){
            stack1.push(cur1.val);
            len1++;
            cur1 = cur1.next;
        }
        int len2 = 0;
        while(cur2 != null){
            stack2.push(cur2.val);
            len2 ++;
            cur2 = cur2.next;

        }
        Stack<Integer> result = new Stack<>();
        while(len1 != len2){
            if(len1 > len2){
                result.push(stack1.pop());
                len1--;
            }else if(len1 < len2){
                result.push(stack2.pop());
                len2--;
            }
        }
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            int a = stack1.pop();
            int b = stack2.pop();
            int c = a+b;
            if(c>=10){
                result.push(result.pop()+1);
            }
            result.push((c)%10);
        }

        ListNode head = new ListNode(0);
        ListNode temp = head;
        while(!result.isEmpty()){
            temp.next = new ListNode(result.pop());
            temp = temp.next;
        }
        return head.next;

    }
}
