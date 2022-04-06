package com.sh.offer.array;

/**
 * @Auther: bjshaohang
 * @Date: 2019/1/27
 */
public class TwoDArraySearch {
    public static void main(String[] args) {
        int[][] array = {{1,2,8,9},{4,7,10,13}};
        System.out.println(find(1,array));
        System.out.println(find2(1,array));
    }

    /**
     * 循环折半查找
     * 一种是：
     把每一行看成有序递增的数组，
     利用二分查找，
     通过遍历每一行得到答案，
     时间复杂度是nlogn
     * @param target
     * @param array
     * @return
     */
    public static boolean find(int target, int [][] array) {
        int rowNum = array.length;

        for(int j = 0 ;j < rowNum; j++){
            int[] line = array[j];
            int mid;
            int low = 0;
            int high = line.length-1;
            while(low <= high){
                mid = (low + high)/2;
                if(line[mid]>target){
                    high = mid -1;
                }else if(line[mid] < target){
                    low = mid + 1;
                }else if(line[mid] == target){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 取两头进行折边查找
     * @param target
     * @param array
     * @return
     */
    public static boolean find2(int target, int [][] array) {
        int col = array[0].length -1;
        int row = 0;

        while (row < array.length && col >=0){
            if(target == array[row][col]){
                return true;
            }
            if (target > array[row][col]){
                row++;
            }else {
                col--;
            }
        }
        return false;
    }

    }
