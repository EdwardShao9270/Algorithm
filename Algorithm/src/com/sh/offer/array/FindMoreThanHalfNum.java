package com.sh.offer.array;

import java.util.Arrays;

/**
 * @Auther: bjshaohang
 * @Date: 2019/3/3
 */
public class FindMoreThanHalfNum {
    public static void main(String[] args) {
        int [] a = {1,2,3,2,4,2,5,2,3};
        System.out.println(new FindMoreThanHalfNum().MoreThanHalfNum_Solution(a));
    }
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length<= 0){
            return 0;
        }
        int result = array[0];
        int time = 1;
        for(int i=0; i<array.length; i++){
            if(time == 0){
                result = array[i];
                time = 1;
            }else if(result == array[i]){
                time++;
            }else{
                time--;
            }
        }
        if(!checkMoreThanHalf(array,result)){
            result = 0;
        }
        return result;
    }
    public boolean checkMoreThanHalf(int[] a,int result){
        int count = 0;
        for(int i =0;i<a.length;i++){
            if(result == a[i]){
                count++;
            }
        }
        if(count >= (a.length/2)){
            return true;
        }
        return false;
    }
}
