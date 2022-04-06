package com.sh.base.sort;

/**
 * 基数排序 也是桶排序的一种
 * 这里面桶的概念就是位排序中每一个数字对应的一个或多个数据项
 * @Auther: bjshaohang
 * @Date: 2019/1/25
 */
public class c2RadixSort {
    public static void main(String[] args) {
        int[] a=new int[]{73,22, 93, 43, 55, 14, 28, 65, 39, 81};
        sort(a, 100);
        for(int num : a)
        {
            System.out.println(num);
        }
    }

    public static void sort(int [] a, int d){
        int n = 1; //1,10,100...
        int k = 0; //保存排序结果索引位置
        int length = a.length;
        int[][] bucket = new int[10][length];

        int [] order = new int[length];  //这个用来记录每个位内数字的顺序，保证数字稳定性

        while (n<d){
            for (int i = 0; i < length; i++) {
                int digit = (a[i]/n)%10;
                bucket[digit][order[digit]] = a[i];
                order[digit]++;
            }

            for (int i = 0; i < length; i++) {
                if(order[i] !=0){
                    for (int j = 0; j < order[i]; j++) {
                        a[k] = bucket[i][j];
                        k++;
                    }
                }
                order[i] = 0;
            }
            n*=10;
            k=0;
        }
    }
}
