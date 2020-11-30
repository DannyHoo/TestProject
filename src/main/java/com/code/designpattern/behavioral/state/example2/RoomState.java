package com.code.designpattern.behavioral.state.example2;

/**
 * @date 2020/11/17下午4:28
 * 房间状态：空闲、预定、入住
 */
public abstract class RoomState {

    protected HotelRoom hotelRoom;

    //预定
    public abstract void orderRoom();

    //退订
    public abstract void cancelOrder();

    //入住
    public abstract void checkIn();

    //入住
    public abstract void checkOut();

}
