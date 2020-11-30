package com.code.algorithm.interview;


import java.util.Random;

/**
 * 在一个长度为100的数组里随机插入100个1-100内的随机数，
 * 要求随机数不能重复，并且不能使用其他类型的数据结构。仅可以使用数组完成。
 * https://blog.csdn.net/dengminghli/article/details/76767742
 */
public class NoRepeatRandom {
    public static void main(String[] args) {

        int[] arrays = new int[10];

        long startTime=System.currentTimeMillis();
        putRandomNumberIntoArrays2(arrays);

        System.out.println("执行完成，随机耗时："+(System.currentTimeMillis()-startTime)+" 结果：\n");

        printArr(arrays);

        /*startTime=System.currentTimeMillis();
        BubbleSort.sort(arrays);
        System.out.println("排序耗时："+(System.currentTimeMillis()-startTime));

        printArr(arrays);*/
    }

    /**
     * 解题思路：
     * 随机生成1-100里面的数字z
     * .
     * 判断是否在数组里面存活
     * 如果存活，则抛弃
     * 如果不存活，添加进数组中
     * 问题：效率不高，多次执行nextInt方法
     * 推荐指数：**
     */
    private static void putRandomNumberIntoArrays1(int[] arrays) {
        int count = 0;
        int i = 1;
        do {
            int randomNumber = new Random().nextInt(10) + 1;
            System.out.println("第" + i++ + "次生成随机数");
            if (!isAlive(randomNumber, arrays)) {
                arrays[count++] = randomNumber;
            }
        } while (!(count == arrays.length));

    }

    /**
     * 解题思路：
     * 在一长度为100数组中，依次存入1-100的数字
     * 随机选取一个下标，将其存储的值与最后一个值交换
     * 把数组的最后一个值加入到数组中，改变下一次随机下标取值范围(-1)
     * 避免了重复数字的出现，避免了多次的循环判断监测，优化效率，但增加内存
     * 推荐指数：***
     */
    private static void putRandomNumberIntoArrays2(int[] arrays) {
        int datalength = 10;
        int[] data = new int[datalength];
        for (int i = 0; i < data.length; i++) {
            data[i] = i + 1;
        }
        System.out.println("初始化原数组：");
        printArr(data);
        System.out.println();

        int count = 0;
        int i = 1;
        do {

            int rand = new Random().nextInt(datalength--);
            System.out.println("第" + i++ + "次生成随机数："+rand);

            int tmp = data[rand];
            data[rand] = data[datalength];
            data[datalength] = tmp;
            System.out.println("原数组：");
            printArr(data);

            arrays[count++] = data[datalength];

            System.out.println("新数组：");
            printArr(arrays);
            System.out.println();
        } while (count != arrays.length);
    }

    private static void putRandomNumberIntoArrays3(int[] arrays) {
        int length = arrays.length;
        int arrOrigin[] = new int[length];
        for (int i = 0; i < length; i++) {
            arrays[i] = i + 1;
        }

        int count = length;
        for (int i = 0; i < length; i++) {

            int random = new Random().nextInt(count + 1);

            int temp=arrays[length-i-1];
            arrays[length-i-1]=arrays[random];
            arrays[random]=temp;
            count--;
        }
    }


    /*
     *判断是否存在
     */
    static boolean isAlive(int number, int[] arrays) {
        boolean isAlive = false;
        for (int i = 0; i < arrays.length; i++) {
            if (number == arrays[i]) {
                isAlive = true;
            }
        }
        return isAlive;
    }

    public static void printArr(int[] arr) {
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
                if (i < arr.length - 1) {
                    System.out.print(",");
                }
            }
        }
        System.out.println();
    }

}
