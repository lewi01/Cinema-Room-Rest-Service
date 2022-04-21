package com.lewisCode.CinemaRoomRestService.Controller;

import com.lewisCode.CinemaRoomRestService.Entities.Cinema;
import com.lewisCode.CinemaRoomRestService.Entities.Seat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CinemaController {

    private final Cinema cinema = new Cinema(9,9);

    @GetMapping("/seats")
    public Cinema getSeats() {
        return cinema;
    }

    @PostMapping("/purchase")
    public Seat purchaseSeat(@RequestBody Seat seat){
       return cinema.purchaseSeat(seat.getRow(), seat.getColumn());
    }
}
