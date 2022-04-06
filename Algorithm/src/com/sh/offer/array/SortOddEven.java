package com.sh.offer.array;

/**
 * @Auther: bjshaohang
 * @Date: 2019/1/29
 */
public class SortOddEven {
    public static void main(String[] args) {
        int [] a = {1,2,3,4,5,6,7};
        new SortOddEven().reOrderArray(a);
        for(int m:a){
            System.out.print(m+" ");
        }
    }

    /**
     * 剑指offer上的解法，不过不满足交换后相对位置不变
     * @param array
     */
    public void recommend(int [] array) {
        int begin = 0;
        int end = array.length-1;
        while (begin<end){
            while(begin<end && !isEven(array[begin])){
                begin++;
            }
            while(begin<end && isEven(array[end])){
                end--;
            }

            if(begin < end){
                int temp = array[begin];
                array[begin] = array[end];
                array[end] = temp;
            }
        }
    }

    public static boolean isEven(int a){
        return a %2 ==0;
    }


    public void reOrderArray(int [] array) {
        for(int i = 0;i<array.length;i++){
            for(int j =0; j<array.length-1-i;j++){
                if(array[j]%2 == 0 && array[j+1]%2 == 1){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
