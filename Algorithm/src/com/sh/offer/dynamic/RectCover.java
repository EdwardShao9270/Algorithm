package com.sh.offer.dynamic;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 其实还是斐波那契数列
 * @Auther: bjshaohang
 * @Date: 2019/1/27
 */
public class RectCover {
    public static void main(String[] args) {

    }

    public int RectCover(int target) {
        if(target ==1 || target ==2){
            return target;
        }
        int firstMin = 2;
        int secondMin = 1;
        int fn = 0;
        for(int i =3;i<=target;i++){
            fn = firstMin + secondMin;
            secondMin = firstMin;
            firstMin = fn;
        }
        return fn;
    }
}
