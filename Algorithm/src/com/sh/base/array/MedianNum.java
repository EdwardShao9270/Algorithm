package com.sh.base.array;

/**
 * 未排序数组的中位数
 *
 * @Auther: bjshaohang
 * @Date: 2019/1/26
 */
public class MedianNum {
    public static void main(String[] args) {
        int [] a = {6,7,8,1,2,3,5,10,4};
        System.out.println(findMedianNum(a,0,a.length-1));
    }

    public static int findMedianNum(int[] a,int begin, int end){
        int median = a.length/2;
        int index =partition(a,begin,end);
        if(index > median){
            a[index] = findMedianNum(a,begin,index-1);
        }else if(index < median){
            a[index] = findMedianNum(a,index+1,end);
        }
        return a[index];
    }

    public static int partition(int[] a, int begin, int end){
        int key = a[begin];
        while (begin < end){
            while ( begin< end && a[end] >= key){
                end --;
            }
            a[begin] = a[end];
            while (begin < end && a[begin] <= key){
                begin ++;
            }
            a[end] = a[begin];
        }
        a[begin] = key;
        return begin;
    }
}
