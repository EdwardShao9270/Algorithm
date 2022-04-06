package com.sh.offer.string;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Auther: bjshaohang
 * @Date: 2019/3/2
 */
public class AllSort {
    public static void main(String[] args) {
        String a = "abcd";
        ArrayList<String> result = new AllSort().Permutation(a);
        result.forEach(k->{
            System.out.println(k);
        });
    }
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if(str == null){
            return list;
        }
        recursive(str.toCharArray(),0,list);
        Collections.sort(list);
        return list;
    }
    public void recursive(char[] a,int index,ArrayList<String> list){
        if(index == a.length-1){
            String str = String.valueOf(a);
            if(!list.contains(str)){
                list.add(str);
            }
        }else{
            for(int j = index; j<a.length; j++){
                char temp = a[j];
                a[j] = a[index];
                a[index] = temp;
                recursive(a,index+1,list);
                temp = a[j];
                a[j] = a[index];
                a[index] = temp;
            }
        }
    }
}
