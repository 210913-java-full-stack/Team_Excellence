import axios from "axios";
import React, { useState, useEffect } from "react";


export default function FlightDetailPage({ id }) {

    const [departLocation, setDepartLocation] = useState()
    const [departTime, setDepartTime] = useState()
    const [departDate, setDepartDate] = useState()
    const [arriveLocation, setArriveLocation] = useState()
    const [arriveTime, setArriveTime] = useState()
    const [arriveDate, setArriveDate] = useState()


    useEffect(() => {
        async function getFlightDetails() {
            document.title = `Flight details for BCON${id}`;
            try {
                let res = await axios.get(`http://localhost:8080/api/flight?id=${id}`)
                setDepartLocation(res.data["departLocation"])
                setDepartTime(res.data["departTime"])
                setDepartDate(res.data["departDate"])
                setArriveLocation(res.data["arriveLocation"])
                setArriveTime(res.data["arriveTime"])
                setArriveDate(res.data["arriveDate"])
                console.log(res.data)
            } catch (error) {
                console.log(error)
            }
        }

        getFlightDetails();
    }, [])


    return (
        <div>

            <div>
                <h1>Flight {id}</h1>
                <h2>Departing</h2>
                <h3>{departLocation}</h3>
                <h3>{departDate}</h3>
                <h3>{departTime}</h3>
                <h2>Arrival</h2>
                <h3>{arriveLocation}</h3>
                <h3>{arriveDate}</h3>
                <h3>{arriveTime}</h3>

            </div>
            <div>
                <button>Buy a ticket!</button>
            </div>

        </div>
    );





}