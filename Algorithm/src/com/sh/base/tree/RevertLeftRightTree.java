package com.sh.base.tree;

import java.util.List;

/**
 * 反转左右子树
 * @Auther: bjshaohang
 * @Date: 2019/1/25
 */
public class RevertLeftRightTree {
    public static void main(String[] args) {
        int[] array = {0,1,2,3,4,5,6,7,8,9,10};
        TreeNode root = TreeNode.makeBinaryTreeByArray(array,1);
        revert(root);
        List<Integer> result = BFS.queueMethod(root);
        for (Integer i:result) {
            System.out.println(i);
        }
    }

    public static void revert(TreeNode root){
        if (root == null){
            return;
        }
        TreeNode temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);

        revert(root.getLeft());
        revert(root.getRight());
    }

}
