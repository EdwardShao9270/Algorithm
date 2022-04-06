package com.sh.offer.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: bjshaohang
 * @Date: 2019/3/3
 */
public class OnlyFirstTimeCharacter {
    public static void main(String[] args) {
        String str = "google";
        System.out.println(new OnlyFirstTimeCharacter().FirstNotRepeatingChar(str));

    }
    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length()<=0){
            return -1;
        }
        char[] a = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int result =-1;
        for(int i = 0; i<a.length; i++){
            if(map.containsKey(a[i])){
                int value = map.get(a[i]);
                map.put(a[i],++value);
            }else{
                map.put(a[i],1);
            }
        }
        for(int j = 0; j<a.length; j++){
            if(map.get(a[j])==1){
                result = j;
            }
        }
        return result;
    }
}
