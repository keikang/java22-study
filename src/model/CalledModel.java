package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class CalledModel {

    public LocalDate date = LocalDate.now();

    public LocalTime time = LocalTime.of(15, 34);

    public String ipAddress = "8.8.8.8";

    public String getOfferType(){
        return "You have a gift waiting for you!";
    }


}
