package com.sh.offer.tree;

import com.sh.base.tree.PreOrder;
import com.sh.leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * 根据前序遍历和中序遍历构造树，并返回树的根节点
 * @Auther: bjshaohang
 * @Date: 2019/1/28
 */
public class RebuldTree {
    public static void main(String[] args) {
        int[] pre = {1,2,3,4};
        int[] in = {1,2,3,4};


        TreeNode result = new RebuldTree().reConstructBinaryTree(pre,in);
        List<Integer> list = unRecursive(result);
        list.forEach(k->{
            System.out.println(k);
        });

    }

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {

        if(pre == null && pre.length == 0  && in == null && in.length ==0){
            return null;
        }

        TreeNode root = new TreeNode(pre[0]);
        doMethod(pre,in,root);

        return root;
    }

    public void doMethod(int[] pre, int [] in, TreeNode root){
        if(pre.length == 1){
            root.left = null;
            root.right = null;
            return;
        }
        int index = 0;
        for (int i = 0 ;i < in.length; i ++){
            if(in[i] == root.val){
                index = i;
                break;
            }
        }

        int[] preLeft = new int[index];
        int[] inLeft = new int[index];

        for (int i = 0;i<index;i++){
            preLeft[i] = pre[i+1];
            inLeft[i] = in[i];
        }
        int size = pre.length -1 -index;


        if(index == 0 ){
            root.left = null;
            if(size == 0){
                return;
            }
        }else {
            root.left = new TreeNode(preLeft[0]);
            doMethod(preLeft,inLeft,root.left);
        }




        int[] preRight = new int[size];
        int[] inRight = new int[size];


        for (int j = 0; j<preRight.length; j++){
            preRight[j] = pre[j+preLeft.length+1];
            inRight[j] = in[j+preLeft.length+1];
        }
        if(size == 0 ){
            root.right = null;
            if(index == 0){
                return;
            }
        }else {
            root.right = new TreeNode(preRight[0]);
            doMethod(preRight,inRight,root.right);
        }

    }

    public TreeNode reConstructBinaryTree2(int [] pre,int [] in) {
        if (pre.length != in.length) {//前序遍历序列与中序遍历序列长度不等
            return null;
        }

        return reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);

    }
    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {

        if(startPre>endPre||startIn>endIn)
            return null;
        TreeNode root=new TreeNode(pre[startPre]);

        for(int i=startIn;i<=endIn;i++)
            if(in[i]==pre[startPre]){
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
            }

        return root;
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
