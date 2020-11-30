package com.code.algorithm.leecode.array;

/**
 * @date 2020/9/1下午10:21
 * 转置矩阵
 * 输入：[[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 *
 * https://blog.csdn.net/weixin_36564655/article/details/79615479
 */
public class P867 {

    public static void main(String[] args) {
        int [ ][ ]  arr=new  int [5][3];
        int[][] input={{1,2,3},{4,5,6}};
        int[][] result=transpose(input);
        System.out.println(result);
    }

    public static int[][] transpose(int[][] A) {
        if (A==null ||A.length==0){
            return null;
        }

        int[][] result=new int[A[0].length][A.length];

        for (int i=0;i<A.length;i++){
            for (int j=0;i<A[0].length;j++){
                result[i][j]=A[j][i];
            }
        }
        return result;
    }
}
