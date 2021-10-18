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

                                <tr key={el.flightId}>
                                    <td>{el.flightId}</td>
                                    <td>{el.departLocation}</td>
                                    <td>{el.departDate}</td>
                                    <td>{el.departTime}</td>
                                    <td>{el.arriveLocation}</td>
                                    <td>{el.arriveDate}</td>
                                    <td>{el.arriveTime}</td>
                                    <button>Veiw Flight {el.flightId} Details</button>
                                </tr>

                            )
                        })
                    }

                </tbody>




            </table>
        </section>

    );


}