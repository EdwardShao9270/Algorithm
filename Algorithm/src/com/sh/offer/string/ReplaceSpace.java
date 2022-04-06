package com.sh.offer.string;

/**
 * @Auther: bjshaohang
 * @Date: 2019/1/27
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer();
        str.append("we are happy");
        System.out.println(replaceSpace(str));

    }
    public static String replaceSpace(StringBuffer str) {
        if(str ==null && str.length() ==0 ){
            return str.toString();
        }

        int length = str.length();
        int newLength = length;
        for(int i = 0 ; i<length; i++){
            if(str.charAt(i) == ' '){
                newLength = newLength +2;
            }
        }
        str.setLength(newLength);
        int index = newLength-1;
        for (int i = length-1; i>=0; i--){
            if(str.charAt(i) == ' '){
                str.setCharAt(index--,'0');
                str.setCharAt(index--,'2');
                str.setCharAt(index--,'%');
            }else {
                str.setCharAt(index--,str.charAt(i));
            }
        }
        return str.toString();
    }
}
