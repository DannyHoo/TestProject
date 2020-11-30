package com.code.designpattern.behavioral.state.example2;

/**
 * @date 2020/11/17下午5:23
 */
public class Main {

    public static void main(String[] args) {
        HotelRoom hotelRoom = new HotelRoom();
        hotelRoom.orderRoom();
        hotelRoom.checkIn();

        hotelRoom.checkIn();
    }

}
