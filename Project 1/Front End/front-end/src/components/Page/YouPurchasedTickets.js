import React from "react";
import "./YouPurchasedTicket.css";


export default function YouPurchasedTickets() {

    document.title = "Thanks from Gautier Airlines";

    return (
        <div className="bought-ticket">
            <div>
                <h1 className="bought">Thank you for choosing Gautier Airlines.</h1>
                <h2>Please grab your bording pass below.</h2>
                <h3>* You are already checked in to your flight.</h3>
            </div>

            <div>
                <a className="bought" href="http://localhost:3000">Go back to flight board</a>
            </div>
        </div>
    );
}