package com.sh.offer.array;

/**
 * @Auther: bjshaohang
 * @Date: 2019/3/1
 */
public class Solution {
    public static void main(String[] args) {
        StringBuffer sb= new StringBuffer("hello world");
        System.out.println(new Solution().replaceSpace(sb));

    }

    public String replaceSpace(StringBuffer sb) {
        if(sb == null){
            return null;
        }
        int oldLength = sb.length();
        int newLength = sb.length();
        for(int i = 0; i<sb.length(); i++){
            if(sb.charAt(i) == ' '){
                newLength+=2;
            }
        }

        StringBuffer newSb = new StringBuffer();
        newSb.setLength(newLength);

        int index = oldLength -1;
        for(int j = newLength -1; j>=0; j--){
            if(sb.charAt(index) == ' '){
                newSb.setCharAt(j,'0');
                newSb.setCharAt(--j,'2');
                newSb.setCharAt(--j,'%');
            }else{
                newSb.setCharAt(j,sb.charAt(index));
            }
            index--;
        }
        return newSb.toString();

    }
}
