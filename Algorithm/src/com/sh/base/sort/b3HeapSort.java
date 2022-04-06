package com.sh.base.sort;

/**
 * 在“堆排序”中的“堆”通常指“二叉堆（binary heap)”，许多不正规的说法说“二叉堆”其实就是一个完全二叉树（complete binary tree），这个说法正确但不准确。但在这基础上理解“二叉堆”就非常的容易了，二叉堆主要满足以下两项属性（properties）：

 #1 - Shape Property: 它是一个完全二叉树。

 #2 - Heap Property: 主要分为max-heap property和min-heap property（这就是我以前说过的术语，很重要）

 　　|--max-heap property ：对于所有除了根节点（root）的节点 i，A[Parent]≥A[i]

 　　|--min-heap property ：对于所有除了根节点（root）的节点 i，A[Parent]≤A[i]

 上图中的两个二叉树结构均是完全二叉树，但右边的才是满足max-heap property的二叉堆。
 *
 *
 * @Auther: bjshaohang
 * @Date: 2019/1/25
 */
public class b3HeapSort {
    public static void main(String[] args) {

        int[] array = {12,20,5,16,15,1,30,45,23,9};
        sort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void sort(int[] a){
        for(int i = 0; i < a.length; i++){
            maxHeap(a,a.length-i);

            int temp = a[0];
            a[0] =  a[a.length-1-i];
            a[a.length-1-i] = temp;
        }
    }

    /**
     * 完成一次建堆，最大值在堆的顶部（根节点）
     * 从最后一个元素开始建堆，主要是为了操作非叶子节点，而且是交换倒数第i个
     * @param a
     * @param size
     */
    public static void maxHeap(int[] a, int size){
        for(int i = size-1; i >= 0; i--){
            heapify(a,i,size);
        }

    }

    /** 建堆
     * 首先，堆维护MAX-HEAPIFY的前提条件是，只有堆顶元素违反堆性质，对其进行调整
     * 建堆BUILD-MAX-HEAP是从后向前调整每一个非叶子结点开始……因为他是调用堆维护MAX-HEAPIFY来建堆的，故而如果要调整当前树，就要首先调整其两棵子树使其满足堆的性质，以保证MAX-HEAPIFY所需要的条件
     * @param a  以完全二叉树理解
     * @param currentRootNode   当前父节点的位置
     * @param size   节点总数
     */
    public static void heapify(int[] a, int currentRootNode,int size){
        if(currentRootNode < size){
            int left = 2 * currentRootNode + 1;
            int right = 2 * currentRootNode + 2;

            //把当前父节点的位置看成是最大的
            int max = currentRootNode;

            if(left < size){
                if (a[left] > a[max]){
                    max = left;
                }
            }

            if(right < size){
                if(a[right] > a[max]){
                    max = right;
                }
            }

            if(max != currentRootNode){
                int temp = a[max];
                a[max] = a[currentRootNode];
                a[currentRootNode] = temp;
                heapify(a,max,size);

            }

        }
    }

}
