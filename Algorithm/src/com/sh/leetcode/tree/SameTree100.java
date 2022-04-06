package com.sh.leetcode.tree;


import com.sh.leetcode.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: bjshaohang
 * @Date: 2019/1/12
 */
public class SameTree100 {
    public static void main(String[] args) {
        int[] array = {0,1,2,3};

        TreeNode pRoot= TreeNode.makeBinaryTreeByArray(array,1);

        int[] array1 = {0,1,2,3};

        TreeNode qRoot= TreeNode.makeBinaryTreeByArray(array1,1);

        System.out.println(isSameTree(pRoot,qRoot));
        System.out.println(isSameTreeRecursive(pRoot,qRoot));


    }

    public static  boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();

        if (p == null || q == null){
            return false;
        }

        pQueue.add(p);
        qQueue.add(q);

        while (!pQueue.isEmpty() || !qQueue.isEmpty()){
            TreeNode pNode = pQueue.remove();
            TreeNode qNode = qQueue.remove();
            if(pNode == null || qNode == null){
                continue;
            }

            if(pNode.val != qNode.val){
                return false;
            }

            if (pNode.left == null && qNode.left != null || pNode.left != null && qNode.left == null){
                return false;
            }else{
                pQueue.add(pNode.left);
                qQueue.add(qNode.left);
            }

            if (pNode.right == null && qNode.right != null || pNode.right != null && qNode.right == null){
                return false;
            }else{
                pQueue.add(pNode.right);
                qQueue.add(qNode.right);
            }

        }


        if (pQueue.size() == 0 && qQueue.size() == 0){
            return true;
        }

        return false;
    }

    public static boolean isSameTreeRecursive (TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }

        if(p == null && q != null || p != null &&  q == null){
            return false;
        }

        if(p.val != q.val){
            return false;
        }

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

}
