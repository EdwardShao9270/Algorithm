package com.sh.offer.array;

/**
 * @Auther: bjshaohang
 * @Date: 2019/1/30
 */
public class Power {
    public static void main(String[] args) {

    }

    public double Power(double base, int exponent) {

        double result = 1.0;

        if(exponent == 0){
            return result;
        }else if(exponent>0){
            for(int i =0;i<exponent;i++){
                result *= base;
            }
        }else{
            exponent = exponent *-1;
            for(int i =0;i<exponent;i++){
                result *= base;
            }
            result = 1/result;
        }
        return result;
    }
}
