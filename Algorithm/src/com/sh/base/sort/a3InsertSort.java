package com.sh.base.sort;

/**
 * @Auther: bjshaohang
 * @Date: 2019/1/25
 */
public class a3InsertSort {
    public static void main(String[] args) {
        int[] array = {12,20,5,16,15,1,30,45,23,9};
        sort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void sort(int [] a){
        int i,j,temp;
        for(i = 1; i<a.length; i++){
            if(a[i] < a[i-1]){
                temp = a[i];
                //元素后移，为插入做准备
                for(j = i; j> 0 && a[j-1] > temp ;j--){
                    a[j] = a[j-1];
                }
                //插入temp
                a[j] = temp;
            }
        }
    }
}
