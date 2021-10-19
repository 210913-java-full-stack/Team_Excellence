package model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tickets")
public class Ticket {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="flight_id", referencedColumnName="flight_id", nullable = false)
    private Flight flight;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id", referencedColumnName="customer_id", nullable = false)
    private Customer customer;

    @Column(name = "passenger_first_name")
    private String passengerFirstName;

    @Column(name = "passenger_last_name")
    private String passengerLastName;

    @Column(name = "passenger_age")
    private Integer passengerAge;

    @Column(name = "checked_in")
    private Boolean checkedIn;

    public Ticket() {
    }

    public Ticket(Integer ticketId, Flight flight, Customer customer, String passengerFirstName, String passengerLastName, Integer passengerAge, Boolean checkedIn) {
        this.ticketId = ticketId;
        this.passengerFirstName = passengerFirstName;
        this.passengerLastName = passengerLastName;
        this.passengerAge = passengerAge;
        this.checkedIn = checkedIn;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getPassengerFirstName() {
        return passengerFirstName;
    }

    public void setPassengerFirstName(String passengerFirstName) {
        this.passengerFirstName = passengerFirstName;
    }

    public String getPassengerLastName() {
        return passengerLastName;
    }

    public void setPassengerLastName(String passengerLastName) {
        this.passengerLastName = passengerLastName;
    }

    public Integer getPassengerAge() {
        return passengerAge;
    }

    public void setPassengerAge(Integer passengerAge) {
        this.passengerAge = passengerAge;
    }

    public Boolean getCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(Boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

}
