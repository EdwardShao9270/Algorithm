package com.sh.base.array;

/**
 * @Auther: bjshaohang
 * @Date: 2019/1/26
 */
public class BinarySearch {
    public static void main(String[] args) {
        int [] a = {1,2,3,4,5,6,7,8};
        System.out.println(binarySearch(a,24));
        System.out.println(binarySearch2(a,24));

    }

    /**
     * 非递归方法
     * @param a
     * @param k
     * @return
     */
    public static boolean binarySearch(int[] a,int k){
        int low = 0;
        int high = a.length -1;
        int mid;
        while (low <= high){
            mid = (low + high)/2;
            if(a[mid] > k){
                high = mid-1;
            }else if(a[mid] <k){
                low = mid+1;
            }else if(a[mid] == k){
                return true;
            }
        }
        return false;
    }

    /**
     * 递归方法
     * @param a
     * @param k
     * @return
     */
    public static boolean binarySearch2(int[] a,int k){
        return search(a,0,a.length-1,k);
    }

    /**
     * 切记要注意if条件
     * @param a
     * @param low
     * @param high
     * @param k
     * @return
     */
    public static boolean search(int[] a, int low,int high,int k){
        if(low <=high){
            int mid = (low + high)/2;
            if(a[mid] == k){
                return true;
            }else if(a[mid] > k){
                search(a,low,mid-1,k);
            }else {
                search(a,mid +1,high,k);
            }
        }
        return false;
    }
}
