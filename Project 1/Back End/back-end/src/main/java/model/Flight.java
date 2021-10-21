package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="flights")
public class Flight {

    @Id
    @Column(name = "flight_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flightId;

    @ManyToOne
    @JoinColumn(name = "pilot_id", referencedColumnName = "pilot_id", nullable = false)
    private Pilot pilot;

    @Column(name = "depart")
    private String departLocation;

    @Column(name = "arrive")
    private String arriveLocation;

    @Column(name = "depart_time")
    private String departTime;

    @Column(name= "depart_date")
    private String departDate;

    @Column(name = "arrive_time")
    private String arriveTime;

    @Column(name = "arrive_date")
    private String arriveDate;

    @Column(name = "take_off")
    private Boolean takeOff;

    @Column(name = "max_number_of_tickets")
    private int maxNumberOfTickets;

    @OneToMany(mappedBy = "flight")
    @JsonIgnore
    private List<Ticket> ticketList;

    public Flight(){

    }

    public Flight(Integer flightId, Pilot pilot, String departLocation, String arriveLocation, String departDate,
                  String departTime, String arriveDate, String arriveTime, Boolean takeOff, Integer maxNumberOfTickets) {

        this.flightId = flightId;
        this.pilot = pilot;
        this.departLocation = departLocation;
        this.arriveLocation = arriveLocation;
        this.departDate = departDate;
        this.departTime = departTime;
        this.arriveDate = arriveDate;
        this.arriveTime = arriveTime;
        this.takeOff = takeOff;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public String getDepartLocation() {
        return departLocation;
    }

    public void setDepartLocation(String departLocation) {
        this.departLocation = departLocation;
    }

    public String getArriveLocation() {
        return arriveLocation;
    }

    public void setArriveLocation(String arriveLocation) {
        this.arriveLocation = arriveLocation;
    }

    public String getDepartTime() {
        return departTime;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    public String getDepartDate() {
        return departDate;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(String arriveDate) {
        this.arriveDate = arriveDate;
    }

    public Boolean getTakeOff() {
        return takeOff;
    }

    public void setTakeOff(Boolean takeOff) {
        this.takeOff = takeOff;
    }

    public int getMaxNumberOfTickets() {
        return maxNumberOfTickets;
    }

    public void setMaxNumberOfTickets(int maxNumberOfTickets) {
        this.maxNumberOfTickets = maxNumberOfTickets;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }
}
