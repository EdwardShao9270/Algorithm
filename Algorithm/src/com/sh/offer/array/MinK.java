package com.sh.offer.array;

import java.util.ArrayList;

/**
 * @Auther: bjshaohang
 * @Date: 2019/3/3
 */
public class MinK {
    public static void main(String[] args) {
        int [] a = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> result = new MinK().GetLeastNumbers_Solution(a,4);
        result.forEach(k->{
            System.out.print(k + " ") ;
        });
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] a, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(a==null || a.length<=0 || k<=0){
            return list;
        }
        int[] topK = new int[k];
        for(int i = 0; i< k; i++){
            topK[i] = a[i];
        }
        buildMaxHeap(topK,k);
        for(int i = k;i<a.length; i++){
            if(a[i] < topK[0]){
                topK[0] = a[i];
                Heapify(topK,0,k);
            }
        }
        for(int i = 0; i< k; i++){
            list.add(topK[i]);
        }
        return  list;
    }

    public void buildMaxHeap(int[] topK,int size){
        for(int i = size-1;i>=0;i--){
            Heapify(topK,i,size);
        }
    }
    public void Heapify(int[] topK, int currentNode,int size){
        if(currentNode < size){
            int left = 2* currentNode +1;
            int right = 2* currentNode +2;
            int max = currentNode;
            if(left<size){
                if(topK[left] > topK[max]){
                    max=left;
                }
            }
            if(right<size){
                if(topK[right] > topK[max]){
                    max=right;
                }
            }
            if(max!=currentNode){
                int temp = topK[max];
                topK[max] = topK[currentNode];
                topK[currentNode] = temp;
                Heapify(topK,max,size);
            }
        }
    }
}
