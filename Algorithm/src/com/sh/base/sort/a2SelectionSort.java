package com.sh.base.sort;

/**
 * 选择排序
 * 从小到大排序：一开始从0~n-1区间上选择一个最小值，将其放在位置0上，然后在1~n-1范围上选取最小值放在位置1上。重复过程直到剩下最后一个元素，数组即为有序。
 * @Auther: bjshaohang
 * @Date: 2019/1/25
 */
public class a2SelectionSort {
    public static void main(String[] args) {
        int[] array = {12,20,5,16,15,1,30,45,23,9};
        sort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void sort(int[] a){
        if(a == null || a.length <=0){
            return;
        }

        for (int i = 0; i < a.length-1; i++) {
            int minIndex= i;

            for (int j = i+1; j < a.length; j++) {
                if(a[j] < a[minIndex]){
                    minIndex = j;
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }
}
