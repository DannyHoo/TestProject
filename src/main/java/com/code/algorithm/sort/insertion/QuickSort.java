package com.code.algorithm.sort.insertion;


import com.code.algorithm.sort.BaseSort;

/**
 * 快速排序
 * https://blog.csdn.net/shujuelin/article/details/82423852
 */
public class QuickSort extends BaseSort {

    //private staticc int array[] = new int[]{21, 65, 13, 44, 5, 9, 98, 12, 13, 31, 90, 44, 69, 55, 19, 33};
    private static int array[] = new int[]{6, 1, 2, 7,9, 3, 4, 5, 10, 8};

    public static void main(String[] args) {
        //partition(array, 0, array.length - 1);
        partition03(array, 0, array.length - 1);
        printArr(array);
    }



    public static void partition03(int array[],int low,int hight){
        // 条件判断
        if (low>hight) return;

        int i=low,j=hight;
        int flag=array[low];
        int[] count=new int[101];
        //当i<j时，遍历交换左半部分和又半部分
        while (i<j){
            while (array[j]>=flag && i<j){
                j--;
            }
            while (array[i]<=flag && i<j){
                i++;
            }
            if (i<j){
                int temp=array[i];
                array[i]=array[j];
                array[j]=temp;
            }
        }
        //此时i==j
        array[low]=array[i];
        array[i]=flag;

        //递归调用左半部分和有半部分，不包括基准数i/j
        partition03(array,low,i-1);
        partition03(array,i+1,hight);
    }

    public static void partition(int array[], int low, int hight) {
        if (low > hight) return;
        int i = low;
        int j = hight;

        //基准数（取最左边的数）
        int flag = array[low];

        //当i<j时，遍历左半部分
        while (i < j) {
            //先遍历右半部分
            while (array[j] >= flag && j > i) {
                j--;
            }
            //再遍历左半部分
            while (array[i] <= flag && i < j) {
                i++;
            }
            //如果满足条件，交换array[j]和array[i]的值
            if (i < j) {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }

        array[low] = array[i];
        array[i] = flag;

        //递归调用左半部分数组
        partition(array, low, j - 1);
        //递归调用右半部分数组
        partition(array, j + 1, hight);
    }


    public static void sort(int[] array, int low, int hight) {
        if (low>hight) return;
        int i = low;
        int j = hight;

        //基准数据
        int flag = array[low];

        while (i < j) {
            while (i < j && array[j] >= flag) {
                j--;
            }
            while (i < j && array[i] <= flag) {
                i++;
            }
            if (i<j){
                int temp=array[j];
                array[j]=array[i];
                array[i]=temp;
            }
        }

        //这时，i==j
        array[low]=array[i];
        array[i]=flag;

        sort(array,low,i-1);
        sort(array,i+1,hight);
    }


    public static void sort02(int[] array,int low,int hight){
        if (array==null || array.length<2 || low>hight){
            return;
        }

        int i=low;
        int j=hight;
        int flag=array[low];//选数组第一个数为基准数

        while (i<j){
            while (i<j && array[j]>=flag){
                j--;
            }
            while (i<j && array[i]<=flag){
                i++;
            }
            if (i<j){
                int temp=array[i];
                array[i]=array[j];
                array[j]=temp;
            }
        }

        //这时i==j
        array[low]=array[i];
        array[i]=flag;

        sort(array,low,i-1);
        sort(array,i+1,hight);
    }
}
