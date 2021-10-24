import React, { useState, useEffect } from "react";
import axios from "axios";

export default function AdminFlightDetail({ flightId, controlFlightPage }) {

    const [departLocation, setDepartLocation] = useState()
    const [departTime, setDepartTime] = useState()
    const [departDate, setDepartDate] = useState()
    const [arriveLocation, setArriveLocation] = useState()
    const [arriveTime, setArriveTime] = useState()
    const [arriveDate, setArriveDate] = useState()
    const [takeOff, setTakeOff] = useState()

    const [tickets, setTickets] = useState([])



    useEffect(() => {



        async function getFlightDetails() {
            document.title = `Flight details for BCON${flightId}`;
            try {
                let res = await axios.get(`http://localhost:8080/api/flight?id=${flightId}`)
                setDepartLocation(res.data["departLocation"])
                setDepartTime(res.data["departTime"])
                setDepartDate(res.data["departDate"])
                setArriveLocation(res.data["arriveLocation"])
                setArriveTime(res.data["arriveTime"])
                setArriveDate(res.data["arriveDate"])
                setTakeOff(res.data["takeOff"])

            } catch (error) {
                console.log(error)
            }
        }

        async function getTicketList() {
            try {
                let res = await axios.get(`http://localhost:8080/api/ticket?flightId=${flightId}`)
                setTickets(res.data)
            } catch (error) {
                console.log(error)
            }

        }

        getTicketList();

        getFlightDetails();
    }, [])




    async function deleteFlight() {
        let a = {
            flightId: flightId,
            departLocation: departLocation,
            departDate: departDate,
            departTime: departTime,
            arriveTime: arriveTime,
            arriveLocation: arriveLocation,
            arriveDate: arriveDate,
            takeOff: takeOff
        }
        try {


            fetch("http://localhost:8080/api/flight", {
                method: "DELETE",
                body: JSON.stringify(a)
            }).catch(err => console.log(err))
        } catch (error) {
            console.log(error)
        }

        controlFlightPage();
    }



    function checked(bool) {
        if (bool) {
            return <td>True</td>
        } else {
            return <td>False</td>
        }
    }





    async function clickTakeOff() {
        setTakeOff(p => p = !p)
        let a = {
            flightId: flightId,
            departLocation: departLocation,
            departDate: departDate,
            departTime: departTime,
            arriveTime: arriveTime,
            arriveLocation: arriveLocation,
            arriveDate: arriveDate,
            takeOff: takeOff
        }

        try {
            await fetch("http://localhost:8080/api/flight", {
                method: "PATCH",
                body: JSON.stringify(a)
            })

        } catch (error) {
            console.log(error)
        }
    }


    return (
        <section>
            <div >
                <h1>{departDate} BCON{flightId} </h1>
                <h2 >Leaving {departLocation} at {departTime}</h2>
                <h2>Arriving {arriveLocation} at {arriveTime}</h2>
                <h3>has taken off: {checked(takeOff)}</h3>
                <button onClick={clickTakeOff}>take off</button>
                <button onClick={deleteFlight}>delete flight</button>
            </div>
            <div className="manifest">
                <table>
                    <thead>
                        <tr>
                            <th>
                                Ticket ID
                            </th>
                            <th>Customer ID</th>
                            <th>Customer First Name</th>
                            <th>Customer Last Name</th>
                            <th>Passenger First Name</th>
                            <th>Passenger Last Name</th>
                            <th>Passenger Age</th>
                            <th>checked in</th>
                        </tr>
                    </thead>
                    <tbody>
                        {tickets.map(el => {
                            return (
                                <tr>
                                    <td>{el.ticketId}</td>
                                    <td>{el.customer.id}</td>
                                    <td>{el.customer.firstName}</td>
                                    <td>{el.customer.lastName}</td>
                                    <td>{el.passengerFirstName}</td>
                                    <td>{el.passengerLastName}</td>
                                    <td>{el.passengerAge}</td>
                                    {checked(el.checkedIn)}


                                </tr>
                            );
                        })}
                    </tbody>
                </table>
            </div>
        </section>
    );
}

