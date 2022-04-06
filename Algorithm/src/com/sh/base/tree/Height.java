package com.sh.base.tree;

/**
 * @Auther: bjshaohang
 * @Date: 2019/1/12
 */
public class Height {

    public static void main(String[] args) {
        int[] array = {0,1,2,3,4,5,6,7,8,9,10};
        TreeNode root = TreeNode.makeBinaryTreeByArray(array,1);
        System.out.println(maxHeight(root));

        System.out.println(minHeight(root));
    }


    /**
     * 二叉树的最大高度，即根节点到叶子节点的最大高度
     *
     * @param root
     * @return
     */
    public static int maxHeight(TreeNode root){
        if(root == null){
            return 0;
        }else {
            int left = maxHeight(root.getLeft());
            int right = maxHeight(root.getRight());
            return Math.max(left,right) + 1;
        }
    }

    /**
     * 二叉树的最小高度，即根节点到叶子节点的最小高度
     *
     * @param root
     * @return
     */
    public static int minHeight(TreeNode root){
        if(root == null){
            return 0;
        }else {
            int left = minHeight(root.getLeft());
            int right = minHeight(root.getRight());
            return Math.min(left,right) + 1;
        }
    }
}
