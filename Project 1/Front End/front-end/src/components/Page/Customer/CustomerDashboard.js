import React, { useState } from 'react';
import "./CustomerDashboard.css";
import FlightBoard from './FlightBoard';
import PurchaseTicket from './PurchaseTicket';







export default function CustomerDashboard({ db_class }) {


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
                    <PurchaseTicket setTicketScreen={setTicketScreen} flightId={flightId} />
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

        <section className={db_class}>
            <div className="flight-board">
                {renderFlightBoard()}
            </div>
            <div className="check-in">
                <div className="container">
                    <h1>Check In</h1>
                </div>
            </div>
            <div className="cancel-ticket">
                <div className="container">
                    <h1>Cancel a Ticket</h1>
                </div>
            </div>



        </section>

    );


}