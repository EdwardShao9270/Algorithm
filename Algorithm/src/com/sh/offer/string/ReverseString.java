package com.sh.offer.string;

/**
 * @Auther: bjshaohang
 * @Date: 2019/3/17
 */
public class ReverseString {
    public static void main(String[] args) {
        String a = "i am a student.";
        System.out.println(new ReverseString().ReverseSentence(a));
    }
    public String ReverseSentence(String str) {
        if(str == null){
            return null;
        }
        if(str.trim().equals("")){
            return str;
        }
        str = reverse(str);
        String[] s = str.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i = s.length-1;i>0;i--){
            if(i==0){
                sb.append(reverse(s[i]));
            }else{
                sb.append(reverse(s[i]));
                sb.append(" ");
            }
        }

        return sb.toString();
    }
    public String reverse(String str){
        char[] a = str.toCharArray();
        int i = 0;
        int j = a.length-1;
        while(i<j){
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
        return new String(a);
    }
}
