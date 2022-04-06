package com.sh.offer.linkedlist;

/**
 * @Auther: bjshaohang
 * @Date: 2019/3/18
 */
public class o1DeleteNode {
    public static void main(String[] args) {

    }
    public void deleteNode(ListNode head,ListNode node){
        if(head == null || node == null){
            return;
        }
        if(node.next != null){
            ListNode deleteNext = node.next;
            node.val = deleteNext.val;
            node.next = deleteNext.next;
            deleteNext = null;
        }else if(head == node) {
            node = null;
            head = null;
        }else {
            ListNode cur = head;
            while (cur != null){
                if(cur.next == node){
                    cur.next = null;
                    node = null;
                }else {
                    cur = cur.next;
                }
            }

        }
    }
}
