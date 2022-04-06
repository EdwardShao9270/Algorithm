package com.sh.offer.tree;

import com.sh.leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: bjshaohang
 * @Date: 2019/1/31
 */
public class MirrorTree {

    public static void main(String[] args) {
        int[] a = {0,8,9,2};
        TreeNode root = TreeNode.makeBinaryTreeByArray(a,1);
        new MirrorTree().Mirror(root);

        List<Integer> result = MirrorTree.unRecursive(root);
        result.forEach(k->{
            System.out.println(k);
        });
    }

    public void Mirror(TreeNode root) {
        if(root == null || (root.right ==null && root.left == null)){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        Mirror(root.left);
        Mirror(root.right);

    }

    /**
     * 非递归实现
     * @param root
     * @return
     */
    public static List<Integer> unRecursive(TreeNode root){
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
