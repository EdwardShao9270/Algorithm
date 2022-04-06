package com.sh.offer.stack;

import java.util.Stack;

/**
 * @Auther: bjshaohang
 * @Date: 2019/2/23
 */
public class SortStack {
    public static void main(String[] args) {

    }

    public static void sort (Stack<Integer> stack){
        Stack<Integer> help = new Stack<>();
        if(!stack.isEmpty()){
            int cur = stack.pop();
            while (!help.isEmpty() && cur < help.peek()){
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()){
            stack.push(help.pop());
        }

    }
}
