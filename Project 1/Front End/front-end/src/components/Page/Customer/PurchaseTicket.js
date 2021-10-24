import React, { useState, useEffect } from "react";
import axios from "axios";
import "./PurchaseTicket.css";

function PurchaseTicket({ setTicketScreen, flightId, id, isLoggedIn }) {
    const [departLocation, setDepartLocation] = useState()
    const [departTime, setDepartTime] = useState()
    const [departDate, setDepartDate] = useState()
    const [arriveLocation, setArriveLocation] = useState()
    const [arriveTime, setArriveTime] = useState()
    const [arriveDate, setArriveDate] = useState()
    const [amountTickets, setAmountTickets] = useState(1)



    useEffect(() => {
        async function getFlightDetails() {
            document.title = `Purchase Ticket for BCON${flightId}`;
            try {
                let res = await axios.get(`http://localhost:8080/api/flight?id=${flightId}`)
                setDepartLocation(res.data["departLocation"])
                setDepartTime(res.data["departTime"])
                setDepartDate(res.data["departDate"])
                setArriveLocation(res.data["arriveLocation"])
                setArriveTime(res.data["arriveTime"])
                setArriveDate(res.data["arriveDate"])
            } catch (error) {
                console.log(error)
            }
        }
        getFlightDetails();
    }, [])

    useEffect(() => {
        renderPassengerInfo();
        console.log(id)
    }, [amountTickets])


    function clickBackButton() {
        setTicketScreen(p => p = !p)
    }

    function renderPassengerInfo() {
        let row = []
        for (var i = 0; i < amountTickets; i++) {
            row.push(row.length + 1)
        }
        return (
            <div >
                {row.map(el => {




                    return (
                        <div key={el}>
                            <h2>Passenger {el}</h2>
                            <label>
                                First Name
                            </label>
                            <input id={`${el}_fname`} name={`${el}_fname`} type="text" required></input>
                            <label>
                                Last Name
                            </label>
                            <input id={`${el}_lname`} name={`${el}_lname`} type="text" required></input>
                            <label>
                                Age
                            </label>
                            <input id={`${el}_age`} name={`${el}_age`} type="number" placeholder="18" required></input>


                        </div>
                    )
                })}
            </div>
        );

    }


    function renderButton() {
        if (isLoggedIn) {
            return <button className="ticket-button" type="submit">Purchse Tickets</button>;
        } else {
            return <h3>You have to be logged in to buy a ticket</h3>
        }
    }



    return (
        <section>
            <div className="buy-ticket">
                <button className="back-button-flights" onClick={clickBackButton}>back</button>
                <h3>{departDate}</h3>

                <h1>Ticket Screen for flight BCON{flightId} from {departLocation} to {arriveLocation}</h1>
                <h3>Ticket price is $150</h3>
                <form method="post" action={`http://localhost:8080/api/ticket?userId=${id}&flightId=${flightId}&numOfTicket=${amountTickets}`}  >
                    <label >
                        How many tickets do you want?
                    </label >
                    <input type="number" placeholder="1" min="1" max="4" onChange={e => setAmountTickets(e.target.value)}></input>
                    {renderPassengerInfo()}
                    {renderButton()}
                </form>



                <h3>Your Total is {amountTickets * 150}</h3>




            </div>
        </section>
    );
}




export default PurchaseTicket;