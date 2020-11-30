package com.code.algorithm.leecode.interviews.p0001;

/**
 * https://leetcode-cn.com/problems/qiu-12n-lcof/
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 输入: n = 3，输出: 6
 * 输入: n = 9，输出: 45
 * n=1 1
 * n=2 1+2=3
 * n=3 1+2+3=9
 * n=4 1+2+3+4=13
 * n=5 1+2+3+4+5=18
 *
 * @author danny
 * @date 2020/6/2下午11:43
 */
public class Sulution1 {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(sumNums(n));
    }

    public static int sumNums(int n) {
        int result = n;
        boolean flag = n > 0 && (result += sumNums(n - 1)) > 0;
        return result;
    }
}
