package com.sh.leetcode.tree;

import com.sh.leetcode.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: bjshaohang
 * @Date: 2019/1/13
 */
public class BalancedBinaryTree110 {
    public static void main(String[] args) {
        int[] array = {0,3,9,22,0,0,15,7};

        TreeNode root= TreeNode.makeBinaryTreeByArray(array,1);

        System.out.println(isBalanced(root));
    }

    public static boolean isBalanced(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        return false;

    }
}
