package com.sh.base.sort;

/**
 * 冒泡排序
 *
 * 冒泡排序从小到大排序：一开始交换的区间为0~N-1，将第1个数和第2个数进行比较，前面大于后面，交换两个数，否则不交换。
 * 再比较第2个数和第三个数，前面大于后面，交换两个数否则不交换。依次进行，最大的数会放在数组最后的位置。然后将范围变为0~N-2，
 * 数组第二大的数会放在数组倒数第二的位置。依次进行整个交换过程，最后范围只剩一个数时数组即为有序。
 * @Auther: bjshaohang
 * @Date: 2019/1/25
 */
public class a1BubbleSort {
    public static void main(String[] args) {
        int[] array = {12,20,5,16,15,1,30,45,23,9};
        sort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void sort(int[] a){
        if(a == null || a.length <= 0){
            return;
        }

        for (int i =0;i<a.length;i++){
            for(int j = 0; j<a.length-1-i;j++){
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
}
