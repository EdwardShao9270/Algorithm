package com.sh.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: bjshaohang
 * @Date: 2019/9/15
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> result = threeSum(nums);
        result.forEach( vo-> {
            vo.forEach( a-> {
                System.out.print(a);
                System.out.print(" ");
            });
        });

    }
    private static List<List<Integer>> threeSum(int [] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length <= 0) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i +1;
            int m = j;
            int n = nums.length - 1;
            while(m < n) {
                if ( nums[m] + nums[n] + nums[i] > 0) {
                    n--;
                } else if (nums[m] + nums[n] + nums[i] < 0){
                    m++;
                } else {
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(nums[i]);
                    tmpList.add(nums[m]);
                    tmpList.add(nums[n]);
                    if (!result.contains(tmpList)) {
                        result.add(tmpList);
                    }
                    m++;
                    n--;
                }
            }
        }


        return result;
    }
}
