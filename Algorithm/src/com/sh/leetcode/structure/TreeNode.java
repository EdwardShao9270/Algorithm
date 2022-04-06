package com.sh.leetcode.structure;

/**
 * @Auther: bjshaohang
 * @Date: 2019/1/12
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode makeBinaryTreeByArray(int[] array,int index){
        if(index<array.length){
            int value=array[index];
            if(value!=0){
                TreeNode t=new TreeNode(value);
                array[index]=0;
                t.left =  makeBinaryTreeByArray(array,index*2);
                t.right = makeBinaryTreeByArray(array,index*2+1);
                return t;
            }
        }
        return null;
    }
}

