package com.code.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 2020/12/29下午3:23
 */
public class BinaryConvert {

    public static void main(String[] args) {
        String decimal = binary2Decimal("1001");
        System.out.println(decimal);

        String binary=decimal2Binary(decimal);
        System.out.println(binary);
    }

    /**
     * 2进制转10进制
     *
     * @param binary
     * @return
     */
    public static String binary2Decimal(String binary) {
        int flag = 0;
        int decimal = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            int num = Integer.valueOf(String.valueOf(binary.charAt(i)));
            decimal += num * Math.pow(2, flag);
            flag++;
        }
        return String.valueOf(decimal);
    }

    /**
     * 10进制转2进制
     *
     * @return
     */
    public static String decimal2Binary(String decimal) {
        int decimalInt=Integer.valueOf(decimal);
        String binary = "";
        while (decimalInt != 0) {
            binary = decimalInt % 2 + binary;
            decimalInt = decimalInt / 2;
        }
        return binary;
    }

    private final static String[] SCALE_ARRAY_26=new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    private final static String[] SCALE_ARRAY_36=new String[]{"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    private final static Map SCALE_MAP_26=new HashMap();
    private final static Map SCALE_MAP_36=new HashMap();
    static {
        SCALE_MAP_26.put("","");
    }

    /**
     * n进制转10进制
     *
     * @param number
     * @return
     */
    public static String scale2Decimal(int scale,String number) {
        int flag = 0;
        int decimal = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            int num = Integer.valueOf(String.valueOf(number.charAt(i)));
            decimal += num * Math.pow(2, flag);
            flag++;
        }
        return String.valueOf(decimal);
    }

    /**
     * 10进制转n进制
     * https://zhidao.baidu.com/question/1957692081990317700.html
     * @return
     */
    public static String decimal2Scale(int scale,String number) {
        int decimalInt=Integer.valueOf(number);
        String binary = "";
        while (decimalInt != 0) {
            binary = decimalInt % scale + binary;
            decimalInt = decimalInt / scale;
        }
        return binary;
    }
}
