package com.sh.base.sort;

/**
 * 希尔排序，是对插入排序的一种优化，也称缩小增量排序,缩小步长后冒泡交换
 *
 * @Auther: bjshaohang
 * @Date: 2019/1/25
 */
public class b4ShellSort {
    public static void main(String[] args) {
        int[] array = {9, 1, 5, 8, 3, 7, 4, 6, 2};
        sort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void sort(int[] a) {
        int i, j, temp;
        int gap = a.length;
        do {
            gap = gap / 3 + 1;
            for (i = gap; i < a.length; i++) {
                if (a[i] < a[i - gap]) {
                    temp = a[i];
                    for (j = i; j-gap>=0 && a[j-gap] > temp; j =j- gap) {
                        a[j] = a[j-gap];
                    }
                    a[j] = temp;
                }
            }
        } while (gap > 1);

    }
}
