package com.sh.offer.tree;

/**
 * @Auther: bjshaohang
 * @Date: 2019/3/2
 */
public class isSquenceOfBST {
    public static void main(String[] args) {
        int[] arr = {4,6,7,5};
        System.out.println(new isSquenceOfBST().VerifySquenceOfBST(arr));

    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null){
            return false;
        }
        return isPost(sequence, sequence.length);
    }
    public boolean isPost(int[] a, int end){

        int root = a[end-1];
        int i = 0;
        while(i< end-2){
            if(a[i] > root){
                break;
            }
            i++;
        }
        int j = i;
        while(j < end-2){
            if(a[j] < root){
                return false;
            }
            j++;
        }

        boolean left = true;
        if(i > 0){
            left = isPost(a,i);
        }
        boolean right = true;
        if(i<end -1){
            right = isPost(a,end -i - 1);
        }
        return left && right;
    }
}
