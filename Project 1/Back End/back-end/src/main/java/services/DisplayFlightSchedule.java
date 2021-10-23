package services;

import model.Flight;
import repository.FlightRepo;

import java.util.ArrayList;
import java.util.List;

public class DisplayFlightSchedule {

    public DisplayFlightSchedule() {
    }

    /**
     * Displays all flights regardless of availability. Used to display flights to the admin.
     */
    public List<Flight> displayFlightsAdmin(){
        return FlightRepo.getAllFlights();
    }

    /**
     * Filter flights based on availability. Used to display flights to the customer.
     */
    public List<Flight> displayFlightsCustomer(){
        List<Flight> listOfAllFights = FlightRepo.getAllFlights();
        List<Flight> flightList = new ArrayList<>();
        for (Flight flight : listOfAllFights) {
            if(!flight.getTakeOff()){
                flightList.add(flight);
            }
        }
        return flightList;
    }

    public Flight displayFlightDetails(int flightId){
        return FlightRepo.getFlightById(flightId);
    }

}
