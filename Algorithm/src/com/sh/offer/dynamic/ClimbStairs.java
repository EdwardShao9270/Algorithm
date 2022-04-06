package com.sh.offer.dynamic;

/**
 * 动态规划典型问题 爬楼梯 斐波那契数列
 * offer p73
 * @Auther: bjshaohang
 * @Date: 2019/1/27
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(new ClimbStairs().JumpFloor2(4));
    }

    /**
     * 效率低下的解法
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        if(target <= 0){
            return 1;
        }
        if(target == 1){
            return 1;
        }
        return JumpFloor(target-1) + JumpFloor(target-2);
    }


    /**
     * o(n)的推荐解法
     * @param target
     * @return
     */
    public int JumpFloor2(int target) {
        if(target <= 0){
            return 0;
        }
        if(target == 1 || target == 2){
            return target;
        }
        int firstMin = 2;
        int secondMin = 1;
        int fn = 0;
        for(int i = 3; i<= target; i++){
            fn = firstMin + secondMin;
            secondMin = firstMin;
            firstMin = fn;
        }
        return fn;
    }
}
