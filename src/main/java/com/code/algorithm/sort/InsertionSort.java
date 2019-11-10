package com.code.algorithm.sort;


/**
 * @author Danny
 * @Title: InsertionSort
 * @Description: 插入排序
 *
 * @Created on 2019-03-31 22:51:28
 */
public class InsertionSort extends BaseSort {

    private static int arr[]=new int[]{9,5,1,3,6,4};
/*
* 9,5,1,3,6,4
* 9,5,1,3,6,4
* 9,5,1,3,6,4
* */

    public static void main(String[] args) {
        for (int i=1;i<arr.length;i++){
            int compareNum=arr[i];
            int leftIndex=i-1;
            while (leftIndex>=0 && arr[leftIndex]>compareNum){
                arr[leftIndex+1]=arr[leftIndex];
                leftIndex--;
            }
            arr[leftIndex+1]=compareNum;
        }

        printArr(arr);
    }
}
