import React, { useState } from 'react';
import "./CustomerDashboard.css";
import FlightBoard from './FlightBoard';
import PurchaseTicket from './PurchaseTicket';
import CheckIn from './CheckIn';
import CancelTicket from './CancelTicket';







export default function CustomerDashboard({ id, db_class, isLoggedIn }) {


    const [ticketScreen, setTicketScreen] = useState(false)
    const [flightId, setFlightId] = useState()

    /**
     * 
     * 
     * 
     */






    function renderFlightBoard() {
        if (ticketScreen) {
            return (
                <div>
                    <PurchaseTicket setTicketScreen={setTicketScreen} flightId={flightId} id={id} isLoggedIn={isLoggedIn} />
                </div>
            );
        } else {
            return (
                <div className="container">
                    <FlightBoard setTicketScreen={setTicketScreen} setFlightId={setFlightId}></FlightBoard>
                </div>
            );
        }
    }




    return (

        <div className={db_class}>

            <div className="flight-board">
                <div className="sub-flight-board">
                    {renderFlightBoard()}
                </div >
            </div>

            <div className="check-in">
                <div className="sub-check-in">
                    <div className="container">
                        <CheckIn />
                    </div>
                </div>
            </div>
            <div className="cancel-ticket">
                <div className="sub-cancel-ticket">
                    <div className="container">
                        <CancelTicket isLoggedIn={isLoggedIn} />
                    </div>
                </div>
            </div>



        </div >

    );


}