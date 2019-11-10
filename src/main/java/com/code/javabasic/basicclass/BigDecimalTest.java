package com.code.javabasic.basicclass;

import java.math.BigDecimal;

/**
 * @author huyuyang@lxfintech.com
 * @Title: BigDecimalTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-09-04 16:05:29
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        /*BigDecimal totalAmount=new BigDecimal("20000.29");
        BigDecimal plan=totalAmount.divide(BigDecimal.valueOf(2),4);
        plan.add(new BigDecimal("2000.029").setScale(BigDecimal.ROUND_DOWN));*/
        new BigDecimal("2000.029").setScale(BigDecimal.ROUND_CEILING,BigDecimal.ROUND_HALF_UP);
    }
}
