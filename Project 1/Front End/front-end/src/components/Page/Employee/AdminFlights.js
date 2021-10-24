import React, { useState, useEffect } from "react";
import axios from "axios";

export default function AdminFlights({ controlCreatePage, controlFlightPage, setFlightId }) {

    const [flights, setFlights] = useState([]);

    useEffect(() => {


        async function getFlights() {
            try {
                const res = await axios.get("http://localhost:8080/api/flights?allFlights=true");
                setFlights(res.data);
            } catch (err) {
                console.log(err)
            }
        }
        getFlights();

    }, []);

    // useEffect(() => {

    //     setTimeout(() => {
    //         (async function getFlights() {
    //             try {
    //                 const res = await axios.get("http://localhost:8080/api/flights?allFlights=true");
    //                 setFlights(res.data);
    //             } catch (err) {
    //                 console.log(err)
    //             }
    //         })();

    //     }, 5000)

    // });





    function departed(bool) {
        if (bool) {
            return <td>True</td>
        } else {
            return <td>False</td>
        }
    }

    function clickCreatePage() {
        controlCreatePage();
    }
    function clickFlightButton(id) {
        setFlightId(id)
        controlFlightPage();

    }



    return (
        <section>
            <h1>Flight List</h1>
            <button className="createPage" onClick={clickCreatePage}>Create New Flight</button>

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
                        <th>Taken Off</th>
                    </tr>
                </thead>

                <tbody >


                    {
                        flights.map(el => {
                            return (

                                <tr key={el.flightId}>

                                    <td><button className="flight-button" onClick={e => clickFlightButton(e.target.value)} value={el.flightId}>BCON  {el.flightId}</button></td>
                                    <td>{el.departLocation}</td>
                                    <td>{el.departDate}</td>
                                    <td>{el.departTime}</td>
                                    <td>{el.arriveLocation}</td>
                                    <td>{el.arriveDate}</td>
                                    <td>{el.arriveTime}</td>
                                    {departed(el.takeOff)}


                                </tr>

                            )
                        })
                    }



                </tbody>





            </table>

        </section>
    );
}





