package com.code.algorithm.sort;

import java.util.Random;

public class BaseSort {

    protected static void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void printArr(int[] arr){
        if (arr!=null){
            for (int i=0;i<arr.length;i++){
                System.out.print(arr[i]);
                if (i<arr.length-1){
                    System.out.print(",");
                }
            }
        }
    }

    public static int[] getMoreRandomNumbers(int length) {
        int[] arr=new int[length];
        for (int i=0;i<length;i++){
            arr[i]=new Random().nextInt(length);
        }
        return arr;
    }

}
