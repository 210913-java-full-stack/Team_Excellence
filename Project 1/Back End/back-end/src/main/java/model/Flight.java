package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Ticket> ticketListByFlightId;

    public Flight(){

    }

    public Flight(String departLocation, String arriveLocation, String departTime, String departDate,
                  String arriveTime, String arriveDate, Boolean takeOff) {
        this.departLocation = departLocation;
        this.arriveLocation = arriveLocation;
        this.departTime = departTime;
        this.departDate = departDate;
        this.arriveTime = arriveTime;
        this.arriveDate = arriveDate;
        this.takeOff = takeOff;
    }

    public Flight(Integer flightId, String departLocation, String arriveLocation, String departTime,
                  String departDate, String arriveTime, String arriveDate, Boolean takeOff) {
        this.flightId = flightId;
        this.departLocation = departLocation;
        this.arriveLocation = arriveLocation;
        this.departTime = departTime;
        this.departDate = departDate;
        this.arriveTime = arriveTime;
        this.arriveDate = arriveDate;
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

    public List<Ticket> getTicketListByFlightId() {
        return ticketListByFlightId;
    }

    public void setTicketListByFlightId(List<Ticket> ticketListByFlightId) {
        this.ticketListByFlightId = ticketListByFlightId;
    }

}

