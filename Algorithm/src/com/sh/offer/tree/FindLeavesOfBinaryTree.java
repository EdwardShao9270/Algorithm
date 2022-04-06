package com.sh.offer.tree;

import com.sh.leetcode.structure.TreeNode;

import java.util.ArrayList;

/**
 * @Auther: bjshaohang
 * @Date: 2019/3/7
 */
public class FindLeavesOfBinaryTree {
    public static void main(String[] args) {
        int[] array = {0,1,2,3,4,5};

        TreeNode root= TreeNode.makeBinaryTreeByArray(array,1);
        ArrayList<ArrayList<Integer>> result = new FindLeavesOfBinaryTree().solution(root);
        result.forEach(k->{
            k.forEach(m->{
                System.out.println(m);
            });
            System.out.println();
        });

    }
    public ArrayList<ArrayList<Integer>> solution(TreeNode root){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        getDepth(root,list);
        return list;
    }

    public int getDepth(TreeNode root, ArrayList<ArrayList<Integer>> list){
        if(root == null){
            return -1;
        }

        int left = getDepth(root.left, list);
        int right = getDepth(root.right, list);
        int curNum = Math.max(left,right) + 1;
        if(curNum == list.size()){
            list.add(new ArrayList<Integer>());
        }
        list.get(curNum).add(root.val);
        return curNum;
    }




}
