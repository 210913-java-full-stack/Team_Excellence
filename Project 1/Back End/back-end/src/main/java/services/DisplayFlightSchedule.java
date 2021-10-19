package services;

import model.Pilot;

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

    //Filter flights based on departure/destination city
    public static void displayFlights(String city){
        //TODO: Write code after implementing Hibernate
    }

    //Filter flights based on availability
    public static void displayFlights(boolean isAvailable){
        //TODO: Write code after implementing Hibernate
    }

    //Displays pilot's schedule for the day. Needs pilot ID and "today's date" ie the date that the pilot is logging in.
    //TODO: Consider changing the return type after implementing Hibernate
    public static void displayPilotSchedule(Pilot pilot){
        //TODO: Write code after implementing Hibernate
    }
}
