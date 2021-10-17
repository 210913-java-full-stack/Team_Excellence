package model;

import java.util.List;
import javax.persistence.*;

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

    @Column(name = "available")
    private Boolean available;

    @Column(name = "max_number_of_tickets")
    private int maxNumberOfTickets;


    public Flight() {
    }


    public Flight(int flightId, Pilots pilots, String departLocation, String arriveLocation, String departDate,
                  String departTime, String arriveDate, String arriveTime, Boolean takeOff, List<Ticket> ticketList,
                  Boolean available, Integer maxNumberOfTickets) {
        this.flightId = flightId;

        this.departLocation = departLocation;
        this.arriveLocation = arriveLocation;
        this.departDate = departDate;
        this.departTime = departTime;
        this.arriveDate = arriveDate;
        this.arriveTime = arriveTime;
        this.takeOff = takeOff;
        this.available = available;
        this.maxNumberOfTickets = maxNumberOfTickets;
    }

    /**
     * Delete after fixing flight servlet
     */
    public Flight(int i, String atl, String mob, String s, int i1, String s1, int i2, boolean b, int i3) {
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

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
