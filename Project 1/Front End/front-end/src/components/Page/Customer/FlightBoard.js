import React, { useState, useEffect } from "react";
import axios from 'axios';








export default function FlightBoard() {

    const [flights, setFlights] = useState([]);

    useEffect(() => {
        async function getFlights() {
            try {
                const res = await axios.get("http://localhost:8080/api/flights");
                setFlights(res.data);
            } catch (err) {
                console.log(err)
            }
        }
        getFlights();
    }, []);


    // return fetch("http://localhost:8080/api/flights")
    //     .then(response => response.json())
    //     .then(data => setFlights(p => p = data[8]))
    //     .catch(error => console.log(error));










    return (
        <section>

            <h1>Checkout our Flights</h1>
            <table>

                <tbody>
                    <tr>
                        <th>
                            Flight Id
                        </th>
                        <th>Departure</th>
                        <th>Departur Date</th>
                        <th>Departure Time</th>
                        <th>Arrival</th>
                        <th>Arrival Date</th>
                        <th>Arrival Time</th>
                    </tr>
                    {
                        flights.map(el => {
                            return (
                                <tr>
                                    <td>{el.flightId}</td>
                                    <td>{el.departLocation}</td>
                                    <td>{el.departDate}</td>
                                    <td>{el.departTime}</td>
                                    <td>{el.arriveLocation}</td>
                                    <td>{el.arriveDate}</td>
                                    <td>{el.arriveTime}</td>
                                </tr>
                            )
                        })
                    }

                </tbody>




            </table>
        </section>

    );


}