package model;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tickets")
public class Ticket {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private Flight flightId;

    @OneToOne
    @JoinColumn(nullable = false)
    private Customer customerId;

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

    public Ticket(Flight flight, Customer customer, String fname, String lname, Integer age) {
        flightId = flight;
        customerId = customer;
        passengerFirstName = fname;
        passengerLastName = lname;
        passengerAge = age;


    }

    public Boolean getCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(Boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public Ticket(int ticketId, Flight flightId, Customer customerId, String passengerFirstName, String passengerLastName, Integer passengerAge, Boolean checkedIn) {
        this.ticketId = ticketId;
        this.flightId = flightId;
        this.customerId = customerId;
        this.passengerFirstName = passengerFirstName;
        this.passengerLastName = passengerLastName;
        this.passengerAge = passengerAge;
        this.checkedIn = checkedIn;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public Flight getFlightId() {
        return flightId;
    }

    public void setFlightId(Flight flightId) {
        this.flightId = flightId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
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
}
