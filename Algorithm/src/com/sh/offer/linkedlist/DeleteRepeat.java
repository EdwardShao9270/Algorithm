package com.sh.offer.linkedlist;

/**
 * @Auther: bjshaohang
 * @Date: 2019/2/27
 */
public class DeleteRepeat {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(9);

        head.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        ListNode result = new DeleteRepeat().deleteDuplication_3(head);
        new  MergeListNode().printLink(result);

    }

    public ListNode deleteDuplication_3(ListNode pHead) {
        if(pHead==null||pHead.next==null)
            return pHead;
        ListNode pPreNode=null;
        ListNode pNode=pHead;
        while(pNode!=null){
            ListNode pNext=pNode.next;
            boolean needDelete=false;
            if(pNext!=null&&pNext.val==pNode.val)
                needDelete=true;
            if(!needDelete){
                pPreNode=pNode;
                pNode=pNode.next;
            }else{
                int value=pNode.val;
                ListNode pToBeDel=pNode;
                while(pToBeDel!=null&&pToBeDel.val==value){
                    pNext=pToBeDel.next;
                    pToBeDel=pNext;
                }
                if(pPreNode==null)
                    pHead=pNext;
                else
                    pPreNode.next=pNext;
                pNode=pNext;
            }
        }
        return pHead;
    }

}
