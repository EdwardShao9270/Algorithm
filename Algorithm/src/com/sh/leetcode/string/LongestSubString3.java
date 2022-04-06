package com.sh.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: bjshaohang
 * @Date: 2019/3/22
 */
public class LongestSubString3 {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(new LongestSubString3().lengthOfLongestSubstring(s));
    }

    /**
     * 自己的解法，时间复杂度为o(n2) 空间复杂度为o(n)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length()==0){
            return 0;
        }
        char[] a = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        int result = 0;
        for(int i = 0; i< a.length; i++){
            for(int j = i;j < a.length; j++){
                if(map.containsKey(a[j])){
                    break;
                }else{
                    map.put(a[j],1);
                    if(result < map.size()){
                        result = map.size();
                    }
                }
            }
            map.clear();
        }
        return result;
    }

    /**
     * 滑动窗口法v1
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if(s == null || s.length()==0){
            return 0;
        }
        int result = 0;
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        while(i < s.length() && j < s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                result = Math.max(result,j-i);
            }else{
                set.remove(s.charAt(i++));
            }
        }

        return result;
    }

    /**
     * 滑动窗口v2
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        if(s == null || s.length()==0){
            return 0;
        }
        int result = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int j = 0,i=0;j< s.length();j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)),i);
            }
            result = Math.max(result, j-i+1);
            map.put(s.charAt(j),j+1);
        }
        return result;
    }

}
