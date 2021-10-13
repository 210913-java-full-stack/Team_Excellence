package services;

import model.Flight;
import model.Pilots;

import java.util.Date;//TODO: Change date datatype after implementing Hibernate

public class DisplayFlightSchedule {

    /*
     * The displayFlights method gets row(s) from the flight table in the database and filters the results based on the
     * given parameters.
     * TODO: Consider changing the return type(s) for the displayFlights method after implementing Hibernate
     */

    //Displays all flights
    public static void displayFlights(){
        //TODO: Write code after implementing Hibernate
    }

    //Filter flights based on date
    //TODO: Change date datatype after implementing Hibernate
    public static void displayFlights(Date date){
        //TODO: Write code after implementing Hibernate
    }

    //Displays pilot's schedule for the day. Needs pilot ID and "today's date" ie the date that the pilot is logging in.
    //TODO: Consider changing the return type after implementing Hibernate
    public static void displayPilotSchedule(){
        Pilots pilots = new Pilots();
        //TODO: Write code after implementing Hibernate
    }
}
