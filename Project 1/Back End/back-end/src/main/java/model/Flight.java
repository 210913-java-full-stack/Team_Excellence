package model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name="flights")
public class Flight {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flightId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private Pilots pilots;

    @Column(name = "depart")
    private String departLocation;

    @Column(name = "arrive")
    private String arriveLocation;

    @Column(name= "depart_date")
    private String departDate;

    @Column(name = "depart_time")
    private Integer departTime;

    @Column(name = "arrive_date")
    private String arriveDate;

    @Column(name = "arrive_time")
    private Integer arriveTime;

    @Column(name = "take_off")
    private Boolean takeOff;

    @OneToMany(mappedBy="tickets")
    private List<Tickets> ticketList = new LinkedList<>();

    @Column(name = "max_number_of_tickets")
    private Integer maxNumberOfTickets;


    public Flight() {
    }

    public Flight(Integer flightId, Pilots pilots, String departLocation, String arriveLocation, String departDate, Integer departTime, String arriveDate, Integer arriveTime, Boolean takeOff, List<Tickets> ticketList, Integer maxNumberOfTickets) {
        this.flightId = flightId;
        this.pilots = pilots;
        this.departLocation = departLocation;
        this.arriveLocation = arriveLocation;
        this.departDate = departDate;
        this.departTime = departTime;
        this.arriveDate = arriveDate;
        this.arriveTime = arriveTime;
        this.takeOff = takeOff;
        this.ticketList = ticketList;
        this.maxNumberOfTickets = maxNumberOfTickets;
    }

    public List<Tickets> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Tickets> ticketList) {
        this.ticketList = ticketList;
    }

    public Integer getMaxNumberOfTickets() {
        return maxNumberOfTickets;
    }

    public void setMaxNumberOfTickets(Integer maxNumberOfTickets) {
        this.maxNumberOfTickets = maxNumberOfTickets;
    }

    public Boolean getTakeOff() {
        return takeOff;
    }

    public void setTakeOff(Boolean takeOff) {
        this.takeOff = takeOff;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public void setDepartTime(Integer departTime) {
        this.departTime = departTime;
    }

    public void setArriveTime(Integer arriveTime) {
        this.arriveTime = arriveTime;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public Pilots getPilots() {
        return pilots;
    }

    public void setPilots(Pilots pilots) {
        this.pilots = pilots;
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

    public String getDepartDate() {
        return departDate;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public int getDepartTime() {
        return departTime;
    }

    public void setDepartTime(int departTime) {
        this.departTime = departTime;
    }

    public String getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(String arriveDate) {
        this.arriveDate = arriveDate;
    }

    public int getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(int arriveTime) {
        this.arriveTime = arriveTime;
    }
}
