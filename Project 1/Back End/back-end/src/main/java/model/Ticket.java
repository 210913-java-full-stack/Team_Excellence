package model;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tickets")
public class Ticket {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="flight_id", referencedColumnName="flight_id")
    private int flightId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id", referencedColumnName="customer_id")
    private int customerId;

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

    public Ticket(Integer ticketId, int flightId, int customerId, String passengerFirstName, String passengerLastName, Integer passengerAge, Boolean checkedIn) {
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

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
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

    public Boolean getCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(Boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

}
