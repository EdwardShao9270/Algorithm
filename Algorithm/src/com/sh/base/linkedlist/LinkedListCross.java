package com.sh.base.linkedlist;

/**
 * @Auther: bjshaohang
 * @Date: 2019/1/26
 */
public class LinkedListCross {
    public static void main(String[] args) {
        BasicOperation list = new BasicOperation();
        list.addNode(1);
        list.addNode(6);

        BasicOperation list2 = new BasicOperation();
        list2.addNode(5);
        list2.addNode(8);
        list2.addNode(7);
        list2.addNode(3);
        list2.addNode(4);
        list2.addNode(2);
        list2.addNode(1);
        list2.addNode(6);

        System.out.println(isCross(list.head,list2.head));
    }

    /**
     * 判断一个链表是否有环
     *
     * @param head
     * @return
     */
    public static boolean isRinged(Node head){
        Node slow = head;
        Node quick = head;
        while (quick.next != null && quick.next.next != null){
            slow = slow.next;
            quick = quick.next.next;
            if(slow == quick){
                return true;
            }
        }
        return false;
    }

    /**
     * 两个链表相交那么尾节点相同
     * @param head1
     * @param head2
     * @return
     */
    public static boolean isCross(Node head1, Node head2){
        Node temp1 = head1;
        Node temp2 = head2;
        while (temp1.next != null){
            temp1 = temp1.next;
        }

        while (temp2.next != null){
            temp2 = temp2.next;
        }

        if(temp1 == temp2){
            return true;
        }
        return false;
    }
    public Node findFirstCrossPoint(BasicOperation linkedList1, BasicOperation linkedList2){
        //链表不相交
        if(!isCross(linkedList1.head,linkedList2.head)){
            return null;
        }else{
            int length1 = linkedList1.length();//链表1的长度
            int length2 = linkedList2.length();//链表2的长度
            Node temp1 = linkedList1.head;//链表1的头结点
            Node temp2 = linkedList2.head;//链表2的头结点
            int len = length1 - length2;//链表1和链表2的长度差

            if(len > 0){//链表1比链表2长，链表1先前移len步
                for(int i=0; i<len; i++){
                    temp1 = temp1.next;
                }
            }else{//链表2比链表1长，链表2先前移len步
                for(int i=0; i<len; i++){
                    temp2 = temp2.next;
                }
            }
            //链表1和链表2同时前移,直到找到链表1和链表2相交的结点
            while(temp1 != temp2){
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            return temp1;
        }
    }
}
