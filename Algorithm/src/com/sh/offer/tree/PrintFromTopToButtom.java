package com.sh.offer.tree;


import com.sh.leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: bjshaohang
 * @Date: 2019/2/2
 */
public class PrintFromTopToButtom {
    public static void main(String[] args) {
        int[] array = {0,1,2,3,4,5,6,7,8,9,10};

        TreeNode root= TreeNode.makeBinaryTreeByArray(array,1);

        ArrayList<Integer> list = new PrintFromTopToButtom().printFromTopToBottom(root);
        list.forEach(k->{
            System.out.println(k);
        });
    }

    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        if(root == null){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right!= null){
                queue.add(node.right);
            }
            result.add(node.val);
        }

        return result;
    }

    public ArrayList<Integer> printFromTopToBottom2(TreeNode root) {
        if (root == null){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(root.val);
        while (root.left != null){
            doMethod(root.left,result);

        }
        while (root.right != null){
            doMethod(root.right,result);
        }
        return result;
    }
    public void doMethod(TreeNode node, ArrayList<Integer> list){
        if (node == null){
            return;
        }
        list.add(node.val);
    }

}
