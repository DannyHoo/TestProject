package com.code.designpattern.behavioral.state.example2;

import lombok.extern.slf4j.Slf4j;

/**
 * @date 2020/11/17下午5:01
 * 房间状态：已预定
 */
@Slf4j
public class OrderedState extends RoomState {

    public OrderedState(HotelRoom hotelRoom) {
        this.hotelRoom=hotelRoom;
    }

    @Override
    public void orderRoom() {
        throw new RuntimeException("Operation now allowed");
    }

    @Override
    public void cancelOrder() {
        log.info("Cancel order success!");
        this.hotelRoom.setRoomState(new FreeState(this.hotelRoom));
    }

    @Override
    public void checkIn() {
        log.info("Check in success!");
        this.hotelRoom.setRoomState(new CheckedInState(this.hotelRoom));
    }

    @Override
    public void checkOut() {
        throw new RuntimeException("Operation now allowed");
    }
}
