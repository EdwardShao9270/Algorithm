package com.sh.base.linkedlist;

/**
 * @Auther: bjshaohang
 * @Date: 2019/1/25
 */
public class LinkListSort {

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

        // Node head = selectionSort(list);
        //Node head = quickSortApi(list.head);
        Node head = mergeSortApi(list.head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * 单链表选择排序，并返回排序后的头节点
     *
     * @return
     */
    public static Node selectionSort(BasicOperation list) {
        //记录每次循环的最小值
        int temp;
        Node curNode = list.getHeadNode();
        while (curNode != null) {
            /**
             * 内重循环从当前节点的下一个节点循环到尾节点，
             * 找到和外重循环的值比较最小的那个，然后与外重循环进行交换
             */
            Node nextNode = curNode.next;
            while (nextNode != null) {
                //比外重循环的小值放到前面
                if (nextNode.value < curNode.value) {
                    temp = nextNode.value;
                    nextNode.value = curNode.value;
                    curNode.value = temp;
                }
                nextNode = nextNode.next;
            }
            curNode = curNode.next;
        }
        return list.getHeadNode();
    }


    /**
     * quicksort api
     *
     * @param head
     * @return
     */
    public static Node quickSortApi(Node head) {
        //采用快速排序
        quickSort(head, null);
        return head;
    }

    /**
     * 单链表快速，并返回排序后的头节点
     *
     * @return
     */
    public static void quickSort(Node begin, Node end) {
        if (begin != end) {
            Node index = partition(begin, end);
            quickSort(begin, index);
            quickSort(index.next, end);
        }

    }

    /**
     * 使第一个节点为中心点
     * 创建2个指针(p，q)，p指向头结点，q指向p的下一个节点
     * q开始遍历,如果发现q的值比中心点的值小，则此时p=p->next，并且执行当前p的值和q的值交换，q遍历到链表尾即可
     * 把头结点的值和p的值执行交换。此时p节点为中心点,并且完成1轮快排
     * 使用递归的方法即可完成排序
     *
     * @param begin
     * @param end
     * @return
     */
    public static Node partition(Node begin, Node end) {

        int key = begin.value;
        Node p1 = begin;
        Node p2 = begin.next;
        while (p2 != end) {
            if  (p2.value < key) {
                p1 = p1.next;
                int temp = p1.value;
                p1.value = p2.value;
                p2.value = temp;

            }
            p2 = p2.next;
        }
        if (p1 != begin) {
            int temp = p1.value;
            p1.value = begin.value;
            begin.value = temp;
        }
        return p1;
    }


    public static Node mergeSortApi(Node head){
        if(head ==null || head.next == null){
            return head;
        }
        Node mid = getMid(head);
        Node right = mid.next;
        mid.next = null; //下次递归时从中间截断head节点
        return mergeSort(mergeSortApi(head),mergeSortApi(right));

    }

    public static Node getMid(Node head){
        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head;
        Node quick = head;
        while (quick.next != null && quick.next.next !=null){
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }

    public static Node mergeSort(Node left,Node right){
        Node p1 = left;
        Node p2 = right;
        Node head = new Node(0);
        Node p = head;
        while (p1 != null && p2 != null){
            if(p1.value <= p2.value){
                p.next = p1;
                p1 = p1.next;
            }else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;

        }

        p.next = (p1==null) ? p2:p1;
        return head.next;
    }
}
