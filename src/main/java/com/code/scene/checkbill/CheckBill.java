package com.code.scene.checkbill;

import java.util.ArrayList;
import java.util.List;

public class CheckBill {

    public static void main(String[] args) {
        List<Order> localOrderList=getLocalOrderList();
        List<Order> channelOrderList=getChannelOrderList();

        for (Order order:localOrderList){

        }

    }

    public static List<Order> getLocalOrderList(){
        List localOrderList=new ArrayList();
        localOrderList.add(new Order().setLocalOrderNo("L001").setChannelOrderNo("C001").setOrderAmount("98").setOrderTime("2019-05-19 10:50:39"));
        localOrderList.add(new Order().setLocalOrderNo("L002").setChannelOrderNo("C002").setOrderAmount("102").setOrderTime("2019-05-19 10:50:39"));
        localOrderList.add(new Order().setLocalOrderNo("L003").setChannelOrderNo("C003").setOrderAmount("6").setOrderTime("2019-05-19 10:50:39"));
        localOrderList.add(new Order().setLocalOrderNo("L004").setChannelOrderNo("C004").setOrderAmount("14").setOrderTime("2019-05-19 10:50:39"));
        localOrderList.add(new Order().setLocalOrderNo("L005").setChannelOrderNo("C005").setOrderAmount("68").setOrderTime("2019-05-19 10:50:39"));
        return localOrderList;
    }

    public static List<Order> getChannelOrderList(){
        List channelOrderList=new ArrayList();
        channelOrderList.add(new Order().setLocalOrderNo("L001").setChannelOrderNo("C001").setOrderAmount("98").setOrderTime("2019-05-19 10:50:39"));
        channelOrderList.add(new Order().setLocalOrderNo("L002").setChannelOrderNo("C002").setOrderAmount("102").setOrderTime("2019-05-19 10:50:39"));
        channelOrderList.add(new Order().setLocalOrderNo("L003").setChannelOrderNo("C003").setOrderAmount("6").setOrderTime("2019-05-19 10:50:39"));
        channelOrderList.add(new Order().setLocalOrderNo("L004").setChannelOrderNo("C004").setOrderAmount("14").setOrderTime("2019-05-19 10:50:39"));
        channelOrderList.add(new Order().setLocalOrderNo("L005").setChannelOrderNo("C005").setOrderAmount("68").setOrderTime("2019-05-19 10:50:39"));
        return channelOrderList;
    }

}
