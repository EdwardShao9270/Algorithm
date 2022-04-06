package com.sh.leetcode.tree;

import com.sh.leetcode.structure.TreeNode;

import java.util.*;

/**
 * @Auther: bjshaohang
 * @Date: 2019/1/13
 */
public class LevelOrderTraversal107 {
    public static void main(String[] args) {
        int[] array = {0,3,9,22,0,0,15,7};

        TreeNode root= TreeNode.makeBinaryTreeByArray(array,1);

        List<List<Integer>> result = dfsSolution(root);

        result.forEach(k->{
            k.forEach(System.out::println);
        });
    }

    /**
     * 自己的做法 借助了hashmap
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null){
            return new LinkedList();
        }

        List<List<Integer>> result = new LinkedList<>();

        Queue<TreeNode> treeQueue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        TreeNode node = root;

        int levelNum = 1;
        treeQueue.add(node);

        while (!treeQueue.isEmpty()) {
            Queue<TreeNode> everyLevel = new LinkedList<>();
            List<Integer> everyInteger = new LinkedList<>();


            while (!treeQueue.isEmpty()){
                everyLevel.add(treeQueue.remove());
            }

            while (!everyLevel.isEmpty()){
                node = everyLevel.remove();
                if(node == null){
                    continue;
                }
                if(node.left != null){
                    treeQueue.add(node.left);
                }

                if(node.right != null){
                    treeQueue.add(node.right);
                }
                everyInteger.add(node.val);
            }

            map.put(levelNum,everyInteger);
            levelNum++;
        }

        for(int i = map.size(); i>=1;i--){
            result.add(map.get(i));
        }

        return result;
    }

    public static List<List<Integer>> bfsSolution(TreeNode root){
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue  = new LinkedList<>();

        if (root == null){
            return new LinkedList<>();
        }

        TreeNode node = root;
        queue.add(node);

        while (!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> list = new LinkedList<>();

            for(int i = 0 ; i < levelNum; i++){
                if(queue.peek().left != null) {
                    queue.add(queue.peek().left);
                }
                if(queue.peek().right != null){
                    queue.add(queue.peek().right);
                }

                list.add(queue.poll().val);
            }
            result.add(0,list);
        }

        return result;

    }


    public static List<List<Integer>> dfsSolution(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();
        recursive(list,root,0);
        return list;
    }

    private static void recursive(List<List<Integer>> list , TreeNode node,int level){
        if (node == null){
            return;
        }

        if(level >= list.size()) {
            list.add(0, new LinkedList<Integer>());
        }

        recursive(list, node.left,level+1);
        recursive(list, node.right,level+1);
        list.get(list.size()-level-1).add(node.val);
    }
}
