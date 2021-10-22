import React, { useState } from 'react';
import "./CustomerDashboard.css";
import FlightBoard from './FlightBoard';
import PurchaseTicket from './PurchaseTicket';







<<<<<<< HEAD
export default function CustomerDashboard({ id, db_class, isLoggedIn }) {


    const [ticketScreen, setTicketScreen] = useState(false)
    const [flightId, setFlightId] = useState()

=======
export default function CustomerDashboard({ db_class }) {
    const [flightId, setFlightId] = useState()
>>>>>>> 39550dca6f31a06ca1a6f002b4f6c06ed8c933f9
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

        <section className={db_class}>
            <div className="flight-board">
<<<<<<< HEAD
                {renderFlightBoard()}
=======
                <div className="container">
                    <FlightBoard setFlightId={setFlightId}></FlightBoard>
                </div>
>>>>>>> 39550dca6f31a06ca1a6f002b4f6c06ed8c933f9
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