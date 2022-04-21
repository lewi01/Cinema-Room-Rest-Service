package com.lewisCode.CinemaRoomRestService.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Seat {
    private int row;
    private int column;
    private int price;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean isPurchased = false;

    public Seat(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.price = price;
    }
}
