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
    @Column(name = "flight_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int flightId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "pilot_id")
    private Pilots pilots;

    @Column(name = "depart")
    private String departLocation;

    @Column(name = "arrive")
    private String arriveLocation;

    @Column(name= "depart_date")
    private String departDate;

    @Column(name = "depart_time")
    private String departTime;

    @Column(name = "arrive_date")
    private String arriveDate;

    @Column(name = "arrive_time")
    private String arriveTime;

    @Column(name = "take_off")
    private Boolean takeOff;



    @Column(name = "max_number_of_tickets")
    private int maxNumberOfTickets;


    public Flight() {
    }


    public Flight(int flightId, Pilots pilots, String departLocation, String arriveLocation, String departDate, String departTime, String arriveDate, String arriveTime, Boolean takeOff,  Integer maxNumberOfTickets) {
        this.flightId = flightId;

        this.departLocation = departLocation;
        this.arriveLocation = arriveLocation;
        this.departDate = departDate;
        this.departTime = departTime;
        this.arriveDate = arriveDate;
        this.arriveTime = arriveTime;
        this.takeOff = takeOff;

        this.maxNumberOfTickets = maxNumberOfTickets;
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

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public int getFlightId() {
        return flightId;
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

    public String getDepartTime() {
        return departTime;
    }



    public String getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(String arriveDate) {
        this.arriveDate = arriveDate;
    }

    public String getArriveTime() {
        return arriveTime;
    }


}