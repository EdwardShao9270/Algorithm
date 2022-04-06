package com.sh.offer.linkedlist;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Auther: bjshaohang
 * @Date: 2019/1/27
 */
public class ReversePrint {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        head.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ArrayList<Integer> result = new ReversePrint().printListFromTailToHead(head);
        result.forEach(k->{
            System.out.println(k);
        });

    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if(listNode == null){
            return result;
        }
        getLast(listNode,result);
        return result;
    }
    private  void getLast(ListNode node,ArrayList<Integer> list){
        if (node.next != null){
            getLast(node.next,list);
        }
        list.add(node.val);
    }


    public ArrayList<Integer> stackMethod(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }
}
