package com.code.scene.doublecolorball.v1;

import java.util.Arrays;

/**
 * @date 2019/12/17下午8:15
 */
public class DoubleColorBall {
    /**
     * 根据双色球生成绝对序号(原理：排列组合算法)
     * a b c d e f 是红球由小到大 g是蓝球
     */
    public static final int getBallIndex(int a, int b, int c, int d, int e, int f, int g) {
        return (comp(33, 6) - comp(34 - a, 6) + comp(33 - a, 5) - comp(34 - b, 5)
                + comp(33 - b, 4) - comp(34 - c, 4) + comp(33 - c, 3) - comp(34 - d, 3)
                + comp(33 - d, 2) - comp(34 - e, 2) + comp(33 - e, 1) - comp(33 - f, 1)) * 16 + g;
    }

    /**
     * 根据绝对序号生成双色球(原理：遍历所有组合）
     * a b c d e f 是红球由小到大
     */
    public static final String getBall(long ballIndex) {
        if (ballIndex > 17721088) {
            ballIndex = ballIndex % 17721088;
        }
        int redIndex = (int) (ballIndex / 16);
        int count = 0;
        for (int a = 1; a < 29; a++) {
            for (int b = a + 1; b < 30; b++) {
                for (int c = b + 1; c < 31; c++) {
                    for (int d = c + 1; d < 32; d++) {
                        for (int e = d + 1; e < 33; e++) {
                            for (int f = e + 1; f < 34; f++) {//最多循环1107568次，即为红球组合数
                                count++;
                                if (redIndex == count) {
                                    return Arrays.toString(new int[]{a, b, c, d, e, f, 1 + ((int) ballIndex - 1) % 16});
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * 计算组合数C(m,n)
     */
    public static final int comp(int m, int n) {
        int sum = 1;
        for (int i = m; i > m - n; i--) {
            sum = sum * i;
        }
        for (int i = n; i > 1; i--) {
            sum = sum / i;
        }
        return sum;
    }

    public static void main(String[] args) {
        //11月29日开奖结果对应序号：
        System.out.println(getBallIndex(6, 20, 28, 29, 30, 31, 12));//12964124
        System.out.println(getBall(12964124));//[6, 20, 28, 29, 30, 31, 12]
        //12月1日开奖结果对应序号：
        System.out.println(getBallIndex(3, 8, 19, 25, 27, 28, 2));//7353378
        System.out.println(getBall(7353378));//[3, 8, 19, 25, 27, 28, 2]
        //12月3日开奖结果对应序号：
        System.out.println(getBallIndex(13, 17, 19, 20, 22, 25, 11));//17009451
        System.out.println(getBall(17009451));//[13, 17, 19, 20, 22, 25, 11]
        System.out.println("预测下次开奖号码,赶快去买吧！");
        System.out.println(getBall(System.nanoTime()));
    }
}
