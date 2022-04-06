package com.sh.base.sort;

/**
 * 计数排序
 * https://www.cnblogs.com/developerY/p/3166462.html
 * @Auther: bjshaohang
 * @Date: 2019/1/25
 */
public class c1CountingSort {
    public static void main(String[] args) {
        int[] a = {2,5,3,0,2,3,04,3};
        int k = 5;
        int[] b = sort(a,k);

        for (int s: b) {
            System.out.println(s);
        }
    }

    public static int[] sort(int[] a, int k){
        int [] c = new int [k+1];
        int length = a.length;
        int sum = 0;

        for (int i = 0; i< length; i++){
            c[a[i]] +=1;
        }

        for(int i = 0; i<k+1; i++){
            c[i] += sum;
            sum = c[i];
        }

        int [] b = new int[length];

        for(int i = length-1; i>=0;i--){
            b[c[a[i]]-1]=a[i];
            c[a[i]]--;
        }

        return b;
    }
}
