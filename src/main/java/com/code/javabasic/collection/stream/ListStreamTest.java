package com.code.javabasic.collection.stream;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @date 2019/12/20下午3:59
 */
public class ListStreamTest {

    public static void main(String[] args) {
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order().setOrderNo("A1").setOrderTime("2019-02-01 00:00:00"));
        orderList.add(new Order().setOrderNo("A2").setOrderTime("2019-02-02 00:00:00"));
        orderList.add(new Order().setOrderNo("A3").setOrderTime("2019-02-03 00:00:00"));
        orderList.add(new Order().setOrderNo("B3").setOrderTime("2019-01-01 00:00:00"));
        orderList.add(new Order().setOrderNo("B5").setOrderTime("2019-01-02 00:00:00"));
        orderList.add(new Order().setOrderNo("B4").setOrderTime("2019-01-02 00:00:00"));

        /* 根据条件过滤 */
        List filterList1 = orderList.stream().filter(
                order -> {
                    return order.getOrderNo().contains("A");
                }
        ).collect(Collectors.toList());

        List filterList2 = orderList.stream().filter(
                order -> order.getOrderNo().contains("A")
        ).collect(Collectors.toList());

        /* 排序 */
        //list.sort排序
        orderList.sort(Comparator.comparing(order -> order.getOrderTime()));
        orderList.sort(Comparator.comparing(order -> order.getOrderTime()));
        List orderList1 = orderList;

        //stream.sorted排序
        List orderList2 = orderList.stream().sorted(Comparator.comparing(Order::getOrderTime).reversed()).collect(Collectors.toList());
        List orderList3 = orderList.stream().sorted(Comparator.comparing(Order::getOrderTime)).collect(Collectors.toList());

        /* 获取所有订单号 */
        List<String> orderNoList=orderList.stream().map(order -> order.getOrderNo()).collect(Collectors.toList());

        System.out.println();

    }

    @Data
    @Accessors(chain = true)
    static class Order {
        private String orderNo;
        private String orderTime;
    }
}
