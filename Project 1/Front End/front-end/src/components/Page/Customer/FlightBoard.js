import React, { useState, useEffect } from "react";
import axios from 'axios';
import FlightDetailPage from "./FlightDetailPage";








export default function FlightBoard({ setTicketScreen, setFlightId }) {


    const [id, setId] = useState()
    const [flights, setFlights] = useState([]);
    const [flightDetails, setFlightDetails] = useState(false);

    useEffect(() => {
        document.title = "Gautier Airlines";
        async function getFlights() {
            try {
                const res = await axios.get("http://localhost:8080/api/flights?allFlights=false");
                setFlights(res.data);
            } catch (err) {
                console.log(err)
            }
        }
        getFlights();
    }, []);

    useEffect(() => {
        setTimeout(() => {
            (async function getFlights() {
                try {
                    const res = await axios.get("http://localhost:8080/api/flights?allFlights=false");
                    setFlights(res.data);
                } catch (err) {
                    console.log(err)
                }
            })();
        }, 5000);
    });






    function controlFlightDetails() {
        setFlightDetails(p => p = !p)
    }



    function clickDetailButton(id) {
        setId(id);
        setFlightId(id)
        controlFlightDetails();
    }




    function renderFlightList() {
        return (
            <section>
                <h1>Checkout our Flights</h1>
                <table>
                    <thead>
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
                    </thead>
                    <tbody>

                        {
                            flights.map(el => {
                                return (

                                    <tr key={el.flightId}>

                                        <td><button className="flight-button" onClick={e => clickDetailButton(e.target.value)} value={el.flightId}>BCON{el.flightId}</button></td>
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





    if (flightDetails) {
        return (
            <div>
                <button className="back-button-flights" onClick={controlFlightDetails}>back</button>
                <FlightDetailPage id={id} setTicketScreen={setTicketScreen} />

            </div>
        );
    }

    return (
        <div>
            {renderFlightList()}
        </div>


    );


}