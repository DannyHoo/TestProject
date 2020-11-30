package com.code.designpattern.behavioral.state.example2;

import lombok.extern.slf4j.Slf4j;

/**
 * @date 2020/11/17下午4:59
 * 房间状态：空闲
 */
@Slf4j
public class FreeState extends RoomState {

    public FreeState(HotelRoom hotelRoom) {
        this.hotelRoom=hotelRoom;
    }

    @Override
    public void orderRoom() {
        log.info("Order room success!");
        this.hotelRoom.setRoomState(new OrderedState(this.hotelRoom));
    }

    @Override
    public void cancelOrder() {
        throw new RuntimeException("Operation now allowed");
    }

    @Override
    public void checkIn() {
        log.info("Chedk in success!");
        this.hotelRoom.setRoomState(new CheckedInState(this.hotelRoom));
    }

    @Override
    public void checkOut() {
        throw new RuntimeException("Operation now allowed");
    }
}
