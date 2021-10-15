import React from 'react';
import "./CustomerDashboard.css";
import FlightBoard from './FlightBoard';







export default function CustomerDashboard({ db_class }) {

    /**
     * 
     * 
     * 
     */

    return (

        <section className={db_class}>
            <div className="flight-board">
                <div className="container">
                    <FlightBoard></FlightBoard>
                </div>
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