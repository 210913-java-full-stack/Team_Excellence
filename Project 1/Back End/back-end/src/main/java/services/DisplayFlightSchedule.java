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
            FlightRepo.setList(FlightRepo.getAllFlights());
            return FlightRepo.getAllFlights();

        }
        System.out.println("display admin List of flights");
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
            FlightRepo.setList(FlightRepo.getAllFlights());
        }
        for(Flight flight : flightList){
            if(!flight.getTakeOff()){
                listOfAvailableFlights.add(flight);
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
        FlightRepo.setList(FlightRepo.getAllFlights());
        return FlightRepo.getFlightById(flightId);
    }

}
