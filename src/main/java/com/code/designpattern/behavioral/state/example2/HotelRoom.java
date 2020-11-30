package com.code.designpattern.behavioral.state.example2;

import lombok.Data;

/**
 * @date 2020/11/17下午4:28
 */
@Data
public class HotelRoom {

    private RoomState roomState;

    public HotelRoom() {
        this.roomState = new FreeState(this);
    }

    //预定
    public void orderRoom(){
        this.roomState.orderRoom();
    }

    //退订
    public void cancelOrder(){
        this.roomState.cancelOrder();
    }

    //入住
    public void checkIn(){
        this.roomState.checkIn();
    }

    //入住
    public void checkOut(){
        this.roomState.checkOut();
    }
}
