package com.sh.base.sort;

/**
 * @Auther: bjshaohang
 * @Date: 2019/1/24
 */
public class b2QuickSort {
    public static void main(String[] args) {
        int[] array = {12,20,5,16,15,1,30,45,23,9};
        int begin = 0;
        int end = array.length-1;
        sort(array,begin,end);
        for (int i : array) {
            System.out.println(i);
        }

    }

    public static void sort(int[] a, int low,int high){
        int start = low;
        int end = high;
        int key = a[start];

        while (end >start){
            while (end > start && key<a[end]){
                end--;
            }
            if(key >= a[end]){
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }

            while (end > start && key > a[start]){
                start++;
            }
            if(key <= a[start]){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
        }
        if (start > low){
            sort(a,low,start-1);
        }
        if (end < high){
            sort(a,end+1,high);
        }
    }
}
