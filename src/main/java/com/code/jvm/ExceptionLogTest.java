package com.code.jvm;

/**
 * 【log.error 没有堆栈信息】
 *  异常时log不打印堆栈信息，可能是由于JVM在多次遇到同一异常信息时，前几次会输出堆栈信息，后面就会主动优化掉，只反馈异常摘要信息
 *  可以添加参数【-XX:-OmitStackTraceInFastThrow】解决
 *  【Java日志出现异常，但没有完整的堆栈信息】https://blog.csdn.net/zzg1229059735/article/details/72567644
 *  【NullPointerException丢失异常堆栈信息】https://blog.csdn.net/taotao4/article/details/43918131
 * @date 2020/7/24上午10:54
 */
public class ExceptionLogTest {

    /**
     * 在捕获异常机几千次后，e.printStackTrace();将不再打印堆栈
     * @param args
     */
    public static void main(String[] args) {
        int i = 0;
        String x= null;
        while (i < 100000000) {
            try {
                System.out.println("当前执行次数为："+i);
                getNPE(x);
            } catch (Exception e) {
                int lth = e.getStackTrace().length;
                System.out.println("length："+lth);
                e.printStackTrace();
                if(lth==0){
                    return;
                }
            }
            i++;
        }


    }

    private static void getNPE(String x) {
        System.out.println("当前字母为：" + x.toString());
    }
}
