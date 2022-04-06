package com.sh.offer.tree;

import com.sh.leetcode.structure.TreeNode;

import java.util.ArrayList;

/**
 * @Auther: bjshaohang
 * @Date: 2019/3/2
 */
public class FindPathIsK {
    public static void main(String[] args) {
        int[] a = {0,10,5,12,4,7};
        TreeNode root1 = TreeNode.makeBinaryTreeByArray(a,1);
        ArrayList<ArrayList<Integer>> resultList = new FindPathIsK().FindPath(root1,22);
        for (ArrayList<Integer> list: resultList){
            for (Integer integer : list){
                System.out.println(integer + " ");
            }
            System.out.println();
        }

    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        recursiveMethod(root,target,result,list);
        return result;
    }

    public void recursiveMethod(TreeNode root,int target, ArrayList<ArrayList<Integer>> result,ArrayList<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null ){
            result.add(new ArrayList<Integer>(list));
        }
        recursiveMethod(root.left,target,result,list);
        recursiveMethod(root.right,target,result,list);
        list.remove(list.size()-1);
    }
}
