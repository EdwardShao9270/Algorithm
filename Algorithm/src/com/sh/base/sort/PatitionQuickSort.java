package com.sh.base.sort;

/**
 *
 * 快速排序的patition sort实现方式
 * @Auther: bjshaohang
 * @Date: 2019/1/26
 */
public class PatitionQuickSort {
    public static void main(String[] args) {
        int[] array = {12,20,5,16,15,1,30,45,23,9};
        int begin = 0;
        int end = array.length-1;
        sort(array,begin,end);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void sort(int[] a, int start,int end){
        if(a == null || a.length ==0 || start >= end){
            return;
        }

        int index = patition(a,start,end);
        if(index>start){
            sort(a,start,index-1);
        }
        if(index<end){
            sort(a,index+1,end);
        }


    }

    public static int patition(int [] a,int start,int end){
        int key = a[start];
        while (end > start){
            while (end > start &&  a[end] >= key){
                end--;
            }
            a[start] = a[end];
            while (end > start &&  a[start] <= key){
                start++;
            }
            a[end] = a[start];
        }
        a[start] = key;
        return start;
    }
}
