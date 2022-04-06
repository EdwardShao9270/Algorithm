package com.sh.offer.stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Auther: bjshaohang
 * @Date: 2019/1/31
 */
public class GetMin {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();
    private int min;

    public static void main(String[] args) {
        GetMin stack = new GetMin();
        stack.push(3);
        System.out.println(stack.min());
        stack.push(4);
        System.out.println(stack.min());
        stack.push(2);
        System.out.println(stack.min());
        stack.push(3);
        System.out.println(stack.min());

        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.push(0);
        System.out.println(stack.min());
    }

    public void push(int node) {
        stack1.push(node);
        if(node > min){
            if(stack2.empty()){
                stack2.push(node);
                min = node;
            }else {
                stack2.push(min);
            }
        }else {
            stack2.push(node);
            min = node;
        }

    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
