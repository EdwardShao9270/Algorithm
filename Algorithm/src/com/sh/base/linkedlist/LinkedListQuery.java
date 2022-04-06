package com.sh.base.linkedlist;

/**
 * 查找链表中正数第k个数和倒数第k个数
 * https://github.com/Snailclimb/JavaGuide/blob/master/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E4%B8%8E%E7%AE%97%E6%B3%95/Leetcode-LinkList1.md
 * @Auther: bjshaohang
 * @Date: 2019/1/26
 */
public class LinkedListQuery {
    public static void main(String[] args) {
        BasicOperation list = new BasicOperation();
        list.addNode(5);
        list.addNode(8);
        list.addNode(7);
        list.addNode(3);
        list.addNode(4);
        list.addNode(2);
        list.addNode(1);
        list.addNode(6);

        //Node result = findReverNode(list,5,list.head);
        Node result = findNode(list,5,list.head);

        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
        System.out.println();

    }

    /**
     *
     * 得到倒数第k个节点
     * @param list
     * @param k
     * @param head
     * @return
     */
    public static Node findReverNode(BasicOperation list,int k,Node head) {
      /*  if(k <1 || k > list.length()){
            return null;
        }*/
        Node first = head;
        Node second = head;
        for (int i = 0; i < k - 1; i++) {
            first = first.next;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }


    /**
     * 正数第k个
     * @param list
     * @param k
     * @param head
     * @return
     */
    public static Node findNode(BasicOperation list,int k,Node head) {

        Node first = head;
        for (int i = 0; i < k - 1; i++) {
            first = first.next;
        }
        return first;
    }

}
