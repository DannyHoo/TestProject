package com.code.designpattern.behavioral.state.example2;

import lombok.extern.slf4j.Slf4j;

/**
 * @date 2020/11/17下午5:00
 * 房间状态：已入住
 */
@Slf4j
public class CheckedInState extends RoomState {

    public CheckedInState(HotelRoom hotelRoom) {
        this.hotelRoom=hotelRoom;
    }

    @Override
    public void orderRoom() {
        throw new RuntimeException("Operation now allowed");
    }

    @Override
    public void cancelOrder() {
        throw new RuntimeException("Operation now allowed");
    }

    @Override
    public void checkIn() {
        throw new RuntimeException("Operation now allowed");
    }

    @Override
    public void checkOut() {
        log.info("Chedk out success!");
        this.hotelRoom.setRoomState(new FreeState(this.hotelRoom));
    }

}
