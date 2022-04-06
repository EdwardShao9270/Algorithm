package com.sh.offer.array;

/**
 * @Auther: bjshaohang
 * @Date: 2021/1/17
 */
public class Main1 {

    public static volatile boolean changeFlag;


    public static void main(String[] args) {
        int[] numArray = {1,2,3,4,5,6,7,8,9};
        String[] letterArray = {"A","B","C","D","E","F","G","H","I"};

        Thread t1 = new Thread(() -> {
            int i = 0;
            while (i < numArray.length){
                if (!changeFlag){
                    System.out.print(numArray[i++] + " ");
                    changeFlag = true;
                }
            }
        });

        Thread t2 = new Thread(() -> {
            int i = 0;
            while (i < letterArray.length){
                if (changeFlag){
                    System.out.print(letterArray[i++] + " ");
                    changeFlag = false;
                }
            }
        });

        t1.start();
        t2.start();
    }
}
