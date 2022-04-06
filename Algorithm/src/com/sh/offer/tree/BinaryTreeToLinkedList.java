package com.sh.offer.tree;

import com.sh.leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: bjshaohang
 * @Date: 2019/3/2
 */
public class BinaryTreeToLinkedList {
    public static void main(String[] args) {
        int[] a = {0,10,5,12,4,7};
        TreeNode root1 = TreeNode.makeBinaryTreeByArray(a,1);
        TreeNode resultList = new BinaryTreeToLinkedList().Convert(root1);
        List<Integer> list = print(resultList);
        list.forEach(k->{
            System.out.print(k + " ");
        });
    }
    public TreeNode Convert(TreeNode root) {
        if(root == null){
            return root;
        }
        if(root.left == null && root.right == null){
            return root;
        }
        TreeNode left = Convert(root.left);
        TreeNode p = left;
        while(p != null && p.right != null){
            p = p.right;
        }
        if(left != null){
            p.right = root;
            root.left = p;
        }
        TreeNode right = Convert(root.right);
        if(right != null){
            right.left = root;
            root.right = right;
        }
        return left!= null? left:root;

    }

    /**
     * 非递归实现
     * @param root
     * @return
     */
    public static List<Integer> print(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        if(root == null){
            return list;
        }
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);

            if(node.right != null){
                stack.push(node.right);
            }

            if(node.left != null){
                stack.push(node.left);
            }
        }
        return list;
    }
}
