package com.sh.leetcode.array;

/**
 *
 * @Auther: bjshaohang
 * @Date: 2019/3/25
 */
public class MedianNumOfTwoSortedArray04 {
    public static void main(String[] args) {
        int[] num1 = {1,2};
        int[] num2 = {3,4};
        System.out.println(new MedianNumOfTwoSortedArray04().findMedianSortedArrays(num1,num2));
    }

    /**
     * 方法1：思路：合并成1个有序数组后求中位数，时间复杂度o(m+n) 空间复杂度o(n)
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length-1;
        int n = nums2.length-1;
        int[] a = new int[m+n+2];
        int index = m+n+1;
        while(m>=0 && n>=0){
            if(nums1[m] <= nums2[n]){
                a[index--] = nums2[n--];
            }else{
                a[index--] = nums1[m--];
            }
        }
        while(m>=0){
            a[index--] = nums1[m--];
        }
        while(n>=0){
            a[index--] = nums2[n--];
        }
        int len = a.length;
        double ans = 0.0;
        if(len %2 == 0){
            ans = (a[len/2-1] + a[len/2])/2.0;
        }else{
            ans = a[len/2];
        }
        return ans;
    }

    /**
     * https://leetcode.com/problems/median-of-two-sorted-arrays/solution/
     * 充分理解中位数的含义进行拆分。
     * 方法2：原题的限制，时间复杂度o(log(m+n))
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m > n){
            int [] temp = nums1;
            nums1 = nums2;
            nums2 = temp;

            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0;
        int iMax = m;
        int mid = (m+n+1)/2;

        while(iMin <= iMax){
            int i = (iMin + iMax)/2;
            int j = mid-i;
            if(i<iMax && nums2[j-1] > nums1[i]){
                iMin = i+1;
            }
            else if(i > iMin && nums1[i-1] > nums2[j]){
                iMax = i-1;
            }else{
                int maxLeft = 0;
                if(i == 0){
                    maxLeft = nums2[j-1];
                }else if(j == 0){
                    maxLeft = nums1[i-1];
                }else{
                    maxLeft = Math.max(nums1[i-1],nums2[j-1]);
                }

                if((m+n) %2 == 1){
                    return maxLeft;
                }
                int minRight = 0;
                if(i == m){
                    minRight = nums2[j];
                }else if(j == n){
                    minRight = nums1[i];
                }else{
                    minRight = Math.min(nums1[i],nums2[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

}
