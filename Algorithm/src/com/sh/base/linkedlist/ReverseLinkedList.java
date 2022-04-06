package com.sh.base.linkedlist;

/**
 * https://www.cnblogs.com/zhengcj/p/7494089.html
 * 反转链表
 * @Auther: bjshaohang
 * @Date: 2019/1/25
 */
public class ReverseLinkedList {
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

        //Node result = reverseList(list.head);

        Node result = reverse(list.head,null);

        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
        System.out.println();
    }

    /**
     * 迭代法  下面的几个方法都没有考虑首节点为null的情况
     * 不借助其他数据结构
     * @param head
     * @return
     */
    private static Node reverseList(Node head) {
        Node prev = null;
        Node cur = head;
        while (cur != null){
            Node temp = cur.next;  //将下个节点记录
            cur.next = prev; //当前节点指向上个节点
            prev = cur; //将当前节点记录为前一个节点
            cur = temp; //下个节点变成当前节点
        }
        return prev;
    }

    /**
     * 递归法
     * @param node
     * @param prev
     * @return
     */
    private static Node reverse(Node node,Node prev){
        if(node.next == null){
            node.next = prev;
            return node;
        }else {
            Node re =reverse(node.next,node);
            node.next = prev;
            return re;
        }
    }

}
