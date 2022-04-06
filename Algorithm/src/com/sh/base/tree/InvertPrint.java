package com.sh.base.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: bjshaohang
 * @Date: 2019/1/12
 */
public class InvertPrint {
    public static void main(String[] args) {
        int [] array = {0,1,2,3,4,5,6,7,8,9,10};
        TreeNode root = TreeNode.makeBinaryTreeByArray(array,1);

    }

    /**
     * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     * 非递归解法
     * @param treeNode
     * @return
     */
    public static List<List<Integer>> invertPrintLevelUnRecursive(TreeNode treeNode){
        List<List<Integer>> list = new LinkedList<>();


        return list;
    }
}
