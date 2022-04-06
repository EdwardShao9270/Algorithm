package com.sh.base.array;

/**
 * 旋转数组的最小元素
 *
 * https://blog.csdn.net/jsqfengbao/article/details/47108069
 *
 *  把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
    输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
    例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * @Auther: bjshaohang
 * @Date: 2019/1/26
 */
public class RevolveArray {
    public static void main(String[] args) {
        int [] a = {6,7,8,1,2,3,4,5};
        System.out.println(minBinarySearch(a));

        int [] b = {1,1,1,0,1};
        System.out.println(minBinarySearch(b));
    }

    /**
     * @return
     */
    public static int minBinarySearch(int[] a){
        int low = 0;
        int high = a.length-1;
        int min = a[low];
        int mid;
        while (a[low] >= a[high]){
            if(high-low == 1){
                min = a[high];
                return min;
            }

            mid = (low + high)/2;
            if(a[low] == a[high] && a[low] == a[mid]){
                min = minAllSearch(a);
            }

            if(a[mid] >= a[low]){
                low = mid;
            }else if(a[mid] < a[high]){
                high = mid;
            }
        }
        return min;
    }


    public static int minAllSearch(int[]a){
        int min=a[0];
        for(int i=1; i<a.length; i++){
            if(min > a[i]){
                min = a[i];
            }
        }
        return min;
    }
}
