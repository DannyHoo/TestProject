package com.code.scene.checkbill;

public class Order{
    /**
     * 我方订单号
     */
    private String localOrderNo;
    /**
     * 渠道订单号
     */
    private String channelOrderNo;
    /**
     * 订单金额
     */
    private String orderAmount;
    /**
     * 订单时间
     */
    private String orderTime;

    public String getLocalOrderNo() {
        return localOrderNo;
    }

    public Order setLocalOrderNo(String localOrderNo) {
        this.localOrderNo = localOrderNo;
        return this;
    }

    public String getChannelOrderNo() {
        return channelOrderNo;
    }

    public Order setChannelOrderNo(String channelOrderNo) {
        this.channelOrderNo = channelOrderNo;
        return this;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public Order setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
        return this;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public Order setOrderTime(String orderTime) {
        this.orderTime = orderTime;
        return this;
    }
}
