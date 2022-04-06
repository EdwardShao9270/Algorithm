package com.sh.base.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: bjshaohang
 * @Date: 2019/1/25
 */
public class BasicOperation {

    public void setHead(Node head) {
        this.head = head;
    }

    Node head = null;

    /**
     * 链表中添加节点
     * @param data
     */
    public  void addNode(int data){
        Node node = new Node(data);
        if (head == null){
            head = node;
            return;
        }
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
    }


    /**
     * 删除node节点 无需担心重复的情况，会循环遍历完成
     * * @param node
     * @return
     */
    public  boolean deleteNode(Node node){
        if (node == null){
            return false;
        }else {
            Node temp = head;
            while (temp.next!=null){
                if(temp.next.value == node.value){
                    temp=temp.next;
                }
            }
            return true;
        }
    }

    /**
     * 删除指定index的节点
     * @param index
     * @return
     */
    public  boolean deleteNodeByIndex(int index){
        if(index < 1 || index > length()){
            return false;
        }
        if(index == 1){
            head = head.next;
            return true;
        }
        Node preNode = head;
        Node curNode = preNode.next;
        int i = 1;
        while (curNode != null){
            if(index == i){
                preNode.next = curNode.next;
                return true;
            }
            preNode = preNode.next;
            curNode = curNode.next;
            i++;
        }
        return true;
    }


    /**
     * 求链表的长度
     * @return
     */
    public  int length(){
        int length = 0;
        Node temp = head;
        while (temp.next!=null){
            length++;
        }
        return length;
    }

    /**
     * 打印结点
     */
    public  void printLink(){
        Node curNode = head;
        while(curNode !=null){
            System.out.print(curNode.value+" ");
            curNode = curNode.next;
        }
        System.out.println();
    }

    /**
     * 链表去重操作
     */
    public  void distinctLink(){
        Node temp = head;
        Node pre = null;
        Map<Integer,Integer> map = new HashMap<>();
        while (temp.next != null){
            if(map.containsKey(temp.value)){
                pre.next = temp.next;
            }else {
                map.put(temp.value,1);
                pre = temp;
            }
            temp = temp.next;
        }
    }

    /**
     * 返回链表的最后一个结点
     */
    public  Node getHeadNode(){
        return head;
    }

    /**
     * 返回链表的最后一个结点
     */
    public  Node getLastNode(){
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 在不知道头结点的情况下删除指定结点：
     * 删除结点的重点在于找出其前结点，使其前结点的指针指向其后结点，即跳过待删除结点
     * 1、如果待删除的结点是尾结点，由于单链表不知道其前结点，没有办法删除
     * 2、如果删除的结点不是尾结点，则将其该结点的值与下一结点交换，然后该结点的指针指向下一结点的后续结点
     * @param node
     * @return
     */
    public  boolean deleteSpecialNode (Node node){
        if(node.next == null){
            return false;
        }else {
            int temp = node.value;
            node.value = node.next.value;
            node.next.value = temp;
            node.next = node.next.next;
            return true;
        }
    }


    public static void main(String[] args) {

    }
}
