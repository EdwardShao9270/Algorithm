package com.sh.offer.array;

/**
 * https://www.cnblogs.com/rainple/p/9988341.html
 * 面试题：基于数组实现一个循环队列
 * @Auther: bjshaohang
 * @Date: 2019/2/27
 */
public class MyQueue {

    /**
     * 队列管道，当管道中存放的数据大于队列的长度时将不会再offer数据，直至从队列中poll数据后
     */
    private Object[] queue;
    //队列的头部，获取数据时总是从头部获取
    private int head;
    //队列尾部，push数据时总是从尾部添加
    private int tail;
    //队列长度
    private int size;

    //数组长度
    private int arrayLength;

    //最大下标
    private int maxIndex;

    public MyQueue(int initSize){
        if (initSize <= 0)
            throw new IndexOutOfBoundsException("initialCapacity must be more than zero");
        queue = new Object[initSize];
        maxIndex = initSize -1;
        head = tail = -1;
        size = 0;
    }

    public void add(Object object){
        if(size > arrayLength){
            System.out.println("queue's size more than or equal to array's capacity");
            return;
        }
        if (++ tail > maxIndex){
            tail = 0;
        }
        queue[tail] = object;
        size ++;
    }


    public Object poll(){
        if (size <= 0){
            System.out.println("the queue is null");
            return null;
        }
        if(++ head > maxIndex){
            head = 0;
        }
        size--;
        Object old = queue[head];
        queue[head] = null;
        return old;
    }
}
