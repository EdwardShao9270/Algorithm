package com.sh.leetcode.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: bjshaohang
 * @Date: 2019/1/29
 */
public class MaxProduct152 {
    public static void main(String[] args) {
        int[] a = {-2,0,-1};
        System.out.println(new MaxProduct152().maxProduct(a));
    }

    public int maxProduct(int[] nums) {
        if(nums == null || nums.length==0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }

        int result = nums[0];
        int max = nums[0];
        int min = nums[0];
        for(int i =1; i<nums.length; i++){
            int temp = max;
            max = Math.max(Math.max(max*nums[i],min*nums[i]),nums[i]);
            min = Math.min(Math.min(temp*nums[i],min*nums[i]),nums[i]);
            if(result < max){
                result = max;
            }
        }
        return result;
    }


    public int maxProducttemp(int[] nums) {
        int result = 0;
        int subCount = 1 << nums.length;
        for (int i = 0; i < subCount; i++) {

            List<Integer> list = new LinkedList<>();
            int temp = i;
            int index = 0;
            while (temp != 0) {
                if ((temp & 1) == 1) {
                    list.add(nums[index]);
                }
                index++;
                temp = temp >> 1;
            }
            if (list.size() != 0) {
                int num = list.get(0);
                for (int m = 1; m < list.size(); m++) {
                    num *= list.get(m);
                }
                if (result < num) {
                    result = num;
                }
            }

        }
        return result;
    }


}
