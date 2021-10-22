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

    @OneToMany(mappedBy = "flight")
    @JsonIgnore
    private List<Ticket> ticketList;

    public Flight(){

    }

    public Flight(Integer flightId, String departLocation, String arriveLocation, String departDate,
                  String departTime, String arriveDate, String arriveTime, Boolean takeOff) {

        this.flightId = flightId;
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

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 39550dca6f31a06ca1a6f002b4f6c06ed8c933f9
