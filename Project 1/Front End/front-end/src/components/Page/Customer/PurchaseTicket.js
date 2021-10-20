import React, { useState, useEffect } from "react";
import axios from "axios";



function PurchaseTicket({ setTicketScreen, flightId }) {
    const [departLocation, setDepartLocation] = useState()
    const [departTime, setDepartTime] = useState()
    const [departDate, setDepartDate] = useState()
    const [arriveLocation, setArriveLocation] = useState()
    const [arriveTime, setArriveTime] = useState()
    const [arriveDate, setArriveDate] = useState()
    const [rows, setRows] = useState([])

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
                            <label>
                                Passenger {el} First Name
                            </label>
                            <input type="text"></input>
                            <label>
                                Passenger {el} Last Name
                            </label>
                            <input type="text"></input>
                            <label>
                                Passenger {el} Age
                            </label>
                            <input type="number" placeholder="18"></input>


                        </div>
                    )
                })}
            </div>
        );

    }






    return (
        <div>
            <button onClick={clickBackButton}>back</button>
            <h3>{departDate}</h3>

            <h1>Ticket Screen for flight BCON{flightId} from {departLocation} to {arriveLocation}</h1>
            <h3>Ticket price is $150</h3>
            <form>
                <label>
                    How many tickets do you want?
                </label>
                <input type="number" placeholder="1" min="1" max="10" onChange={e => setAmountTickets(e.target.value)}></input>
                {renderPassengerInfo()}
            </form>



            <h3>Your Total is {amountTickets * 150}</h3>




        </div>
    );
}




export default PurchaseTicket;