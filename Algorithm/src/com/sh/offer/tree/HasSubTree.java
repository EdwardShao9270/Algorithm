package com.sh.offer.tree;


import com.sh.leetcode.structure.TreeNode;

/**
 * @Auther: bjshaohang
 * @Date: 2019/1/30
 */
public class HasSubTree {
    public static void main(String[] args) {
        int[] a = {8,8,7,9,2,0,0,0,0,4,7};
        int[] b = {8,9,2};
        TreeNode root1 = TreeNode.makeBinaryTreeByArray(a,0);
        TreeNode root2 = TreeNode.makeBinaryTreeByArray(b,0);
        System.out.println(new HasSubTree().hasSubtree(root1,root2));
    }

    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if(root2 == null){
            return true;
        }
        if(root1 == null){
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }

        return hasSubtree(root1.left,root2.left) && hasSubtree(root1.right,root2.right);
    }
}
