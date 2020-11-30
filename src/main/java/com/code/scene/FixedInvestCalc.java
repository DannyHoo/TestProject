package com.code.scene;

import java.math.BigDecimal;

/**
 * 定投复利计算
 * @date 2020/7/27下午3:26
 */
public class FixedInvestCalc {

    private final static Integer daysPerYear=365;//投资总天数
    private final static Integer weeksPerYear=52;//投资总周数
    private final static Integer monthsPerYear=12;//投资总月数

    public static void main(String[] args) {

        // 年收益率
        BigDecimal yearRate=BigDecimal.valueOf(0.1);
        // 投资次数
        Integer cycle=monthsPerYear;
        // 每次定投金额
        BigDecimal investAmount=BigDecimal.valueOf(1000);

        // 每个投资周期利率
        BigDecimal calcRate=yearRate.divide(BigDecimal.valueOf(cycle),10,BigDecimal.ROUND_HALF_UP);
        // 总本金
        BigDecimal totalPrincipal=BigDecimal.ZERO;
        // 总收益
        BigDecimal totalIncome=BigDecimal.ZERO;
        // 总金额
        BigDecimal totalAmount=BigDecimal.ZERO;

        // 定投计算
        for (int i=1;i<=cycle;i++){
            //当前周期定投后总金额
            totalAmount=totalAmount.add(investAmount);
            //当前投资周期收益
            BigDecimal income=totalAmount.multiply(calcRate).setScale(10,BigDecimal.ROUND_HALF_UP);

            //总本金累加
            totalPrincipal=totalPrincipal.add(investAmount);
            //总收益累加
            totalIncome=totalIncome.add(income);
            //总金额累加
            totalAmount=totalPrincipal.add(totalIncome);
        }

        System.out.println("最终总本金："+totalPrincipal.toString());
        System.out.println("最终总收益："+totalIncome.toString());
        System.out.println("最终总金额："+totalAmount.toString());
    }
}
