package model;

import java.util.Date;

public class Flight {
    private int flightId;
    private int pilotId;
    private String departLocation;
    private String arriveLocation;
    private String departDate;
    private int departTime;
    private String arriveDate;
    private int arriveTime;

    public Flight() {
    }

    public Flight(int flightId, int pilotId, String departLocation, String arriveLocation, String departDate, int departTime, String arriveDate, int arriveTime) {
        this.flightId = flightId;
        this.pilotId = pilotId;
        this.departLocation = departLocation;
        this.arriveLocation = arriveLocation;
        this.departDate = departDate;
        this.departTime = departTime;
        this.arriveDate = arriveDate;
        this.arriveTime = arriveTime;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getPilotId() {
        return pilotId;
    }

    public void setPilotId(int pilotId) {
        this.pilotId = pilotId;
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
