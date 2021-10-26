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
     * @return Returns a list of all flights
     */
    public List<Flight> displayFlightsAdmin(){
        List<Flight> flightList = FlightRepo.getFlightList();
        if(flightList == null){
            FlightRepo.setFlightList(FlightRepo.getAllFlights());
            return FlightRepo.getAllFlights();

        }
        return flightList;
    }

    /**
     * Filter flights based on availability. Used to display flights to the customer.
     * @return Returns a list containing all available flights
     */
    public List<Flight> displayFlightsCustomer(){
        List<Flight> listOfAvailableFlights = new ArrayList<>();
        List<Flight> flightList = FlightRepo.getFlightList();
        if(flightList == null){
            flightList = FlightRepo.getAllFlights();
            FlightRepo.setFlightList(FlightRepo.getAllFlights());
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
        FlightRepo.setFlightList(FlightRepo.getAllFlights());
        return FlightRepo.getFlightById(flightId);
    }

}
