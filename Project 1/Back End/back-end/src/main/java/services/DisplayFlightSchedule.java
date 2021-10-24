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
        List<Flight> flightList = FlightRepo.getList();
        if(flightList == null){
            return FlightRepo.getAllFlights();
        }
        return flightList;
    }

    /**
     * Filter flights based on availability. Used to display flights to the customer.
     */
    public List<Flight> displayFlightsCustomer(){
        List<Flight> listOfAvailableFlights = new ArrayList<>();
        List<Flight> flightList = FlightRepo.getList();
        if(flightList == null){
            flightList = FlightRepo.getAllFlights();
        }
        for(int i = 0; i < flightList.size();i++){
            if(!flightList.get(i).getTakeOff()){
                listOfAvailableFlights.add(flightList.get(i));
            }
        }
        return listOfAvailableFlights;
    }

    /**
     * Displays the details of an individual flight.
     * @param flightId Requires the flight ID
     * @return Returns the flight information
     */
    public Flight displayFlightDetails(int flightId){
        return FlightRepo.getFlightById(flightId);
    }

}
