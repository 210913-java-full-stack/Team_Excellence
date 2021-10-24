import React, { useState } from "react";
import "./CancelTicket.css";


function CancelTicket({ isLoggedIn }) {
    const [ticketId, setTicketId] = useState()


    function renderButton() {
        if (isLoggedIn) {
            return <button>Cancel Ticket {ticketId}</button>
        } else {
            return (<h3>Must be logged in to cancel ticket</h3>)
        }
    }

    return (
        <div className="cancel">
            <h1>Cancel Your Ticket</h1>
            <div>
                <input type="text" onChange={e => setTicketId(e.target.value)} />
            </div>

            {renderButton()}
        </div>
    );
}

export default CancelTicket;
