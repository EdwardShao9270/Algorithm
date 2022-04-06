package com.sh.base.sort;

/**
 * @Auther: bjshaohang
 * @Date: 2019/1/24
 */
public class b1MergeSort {
    public static void main(String[] args) {
        int[] array = {12,20,5,16,15,1,30,45,23,9};
        int begin = 0;
        int end = array.length-1;
        sort(array,begin,end);
        for (int i : array) {
            System.out.println(i);
        }

    }

    public static void sort(int [] a, int low, int high){
        int mid = (low + high) / 2;
        if(low < high){
            sort(a,low,mid);
            sort(a,mid+1,high);
            merge(a,low,mid,high);
        }
    }

    public static void merge(int[] a, int low, int mid, int high){
        int i = low;
        int j = mid +1;
        int k = 0;
        int[] temp = new int[high-low+1];
        while (i <= mid && j <=high){
            if(a[i] < a[j]){
                temp[k++] = a[i++];
            }else {
                temp[k++] = a[j++];
            }
        }

        while (i <= mid){
            temp[k++] = a[i++];
        }

        while (j <= high){
            temp[k++] = a[j++];
        }

        for(int x = 0; x < temp.length; x++){
            a[x+low] = temp[x];
        }

    }
}
