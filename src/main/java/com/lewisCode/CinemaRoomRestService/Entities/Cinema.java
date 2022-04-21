package com.lewisCode.CinemaRoomRestService.Entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Cinema {

     private int total_rows;
     private int total_columns;
     private List<Seat> available_Seats = new ArrayList<>();

     public Cinema(int rows, int columns) {
            this.total_rows =rows;
            this.total_columns = columns;
            for (int row = 1; row <= rows; row++) {
              for (int column = 1; column <= columns; column++) {
                  available_Seats.add(new Seat(row, column,(row<=4?10:8)));
             }
            }
     }
     public Seat purchaseSeat(int row, int column){
         for(Seat seat: available_Seats){
             if (seat.getRow() == row && seat.getColumn() == column){
                 if (!seat.isPurchased()){
                     seat.setPurchased(true);
                     return seat;
                 }else {
                     throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                             "The ticket has been already purchased!");
                 }
             }

         }
         throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                 "The number of a row or a column is out of bounds!");
     }

}
