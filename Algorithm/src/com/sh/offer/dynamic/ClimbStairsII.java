package com.sh.offer.dynamic;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 结果为2^(n-1)
 * @Auther: bjshaohang
 * @Date: 2019/1/27
 */
public class ClimbStairsII {
    public static void main(String[] args) {

    }
    public int JumpFloorII(int target) {
        if (target ==1 || target == 0){
            return target;
        }
        int fn = 0;
        int a = 1;
        for(int i = 0; i<target-1;i++){
            fn = a * 2;
            a = fn;
        }
        return fn;
    }

}
