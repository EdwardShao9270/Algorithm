package com.sh.offer.array;

/**
 * @Auther: bjshaohang
 * @Date: 2019/3/17
 */
public class GetNumberOfKInSortArray {
    public static void main(String[] args) {
        int[] a = {1,2,3,3,3,3};
        System.out.println(new GetNumberOfKInSortArray().GetNumberOfK(a,3));
    }
    public int GetNumberOfK(int [] a , int k) {
        if(a == null || a.length<=0 || k<0){
            return 0;
        }
        int low = 0;
        int high = a.length -1;
        int mid = 0;
        int count = 0;
        while(low < high){
            mid = (low + high)/2;
            if(a[mid] > k){
                high = mid;
            }else if(a[mid] < k){
                low = mid;
            }else{
                while(mid>=0 && a[mid] == k ){
                    mid--;
                }
                if(mid != 0 ){
                    mid++;
                }
                while(mid < a.length && a[mid] == k){
                    count++;
                    mid++;
                }
                return count;
            }
        }

        return 0;
    }
}
