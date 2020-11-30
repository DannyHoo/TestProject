package com.code.utils;

/**
 * @author danny
 * @date 2020/5/25下午5:27
 */
public class PrintUtil {
    public static void printWithTime(String str) {
        System.out.println(
                DateUtils.getNewFormatDateString(DateUtils.getNowDate())
                        + str
        );
    }
}
