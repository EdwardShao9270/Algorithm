package com.sh.base.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的宽度
 * 上一层出队后，下一层入队做好交接
 * @Auther: bjshaohang
 * @Date: 2019/1/12
 */
public class Width {
    public static void main(String[] args) {
        int[] array = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        TreeNode root = TreeNode.makeBinaryTreeByArray(array,1);
        System.out.println(maxWidth(root));
    }

    public static int maxWidth(TreeNode root){
        if(root == null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int maxWidth = 1;
        queue.add(root);

        while (true){
            int len = queue.size();
            if(len == 0){
                break;
            }
            //上一层遍历完后，下一层的宽度即为队列中元素的个数，最后比较两者大小
            while (len > 0){
                TreeNode node = queue.poll();
                len --;
                if(node.getLeft() != null){
                    queue.add(node.getLeft());
                }

                if (node.getRight() != null){
                    queue.add(node.getRight());
                }
            }

            maxWidth = Math.max(maxWidth,queue.size());

        }
        return maxWidth;
    }
}
