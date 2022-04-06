package com.sh.base.array;

/**
 * 利用最小堆解决topk问题
 * https://blog.csdn.net/huki925/article/details/38846147
 *
 * @Auther: bjshaohang
 * @Date: 2019/1/27
 */
public class Topk {
    public static void main(String[] args) {
        // 源数据
        int[] data = {56, 275, 12, 6, 45, 478, 41, 1236, 456, 12, 546, 45};

        // 获取Top5
        int[] topK = topK(data, 5);

        for (int i = 0; i < 5; i++) {
            System.out.println(topK[i]);
        }
    }

    private static int[] topK(int[] a, int k) {
        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = a[i];
        }
        buildMinHeap(topK, topK.length);

        for (int i = k; i < a.length; i++) {
            if (a[i] > topK[0]) {
                topK[0] = a[i];
                heapify(topK, 0, topK.length);
            }
        }
        return topK;
    }

    private static void buildMinHeap(int[] a, int size) {
        for (int i = size - 1; i >= 0; i--) {
            heapify(a, i, size);
        }
    }

    private static void heapify(int[] a, int currentRoot, int size) {
        if (currentRoot < size) {
            int left = 2 * currentRoot + 1;
            int right = 2 * currentRoot + 2;

            int min = currentRoot;
            if (left < size) {
                if (a[left] < a[min]) {
                    min = left;
                }

            }

            if (right < size) {
                if (a[right] < a[min]) {
                    min = right;
                }
            }

            if (min != currentRoot) {
                int temp = a[min];
                a[min] = a[currentRoot];
                a[currentRoot] = temp;
                heapify(a, min, size);
            }

        }
    }
}
