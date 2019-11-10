package com.code.algorithm.sort;

/**
 * @author Danny
 * @Title: BubbleSort
 * @Description: 冒泡排序
 * 时间复杂度O(n2)
 * 稳定
 * @Created on 2019-03-31 22:48:16
 */
public class BubbleSort extends BaseSort {

    private static int arr[]=new int[]{21,65,13,44,5,9,98,12,13,31,90,44,69,55,19,33};
    //private staticc int arr[]=new int[]{1,2,3,4,5};

    public static void main(String[] args) {
        sort(arr);
        printArr(arr);
    }

    public static void sort(int arr[]){
        boolean quit=true;

        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length-i-1;j++){
                if (arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    quit=false;
                }
            }
            if (quit){
                System.out.println("循环遍历了"+(i+1)+"遍，提前退出");
                break;
            }
        }
    }

    protected static void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }


}
