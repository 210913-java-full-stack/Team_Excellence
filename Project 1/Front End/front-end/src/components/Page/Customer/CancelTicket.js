import React, { useState } from "react";
import "./CancelTicket.css";


function CancelTicket({ isLoggedIn, id }) {
    const [ticketId, setTicketId] = useState()



    async function handleClick() {


        await fetch(`http://localhost:8080/api/ticket?ticketId=${ticketId}&customerId=${id}`, {
            method: "DELETE",

        }).then(response => {
            if (response.ok) {
                alert("You have deleted your ticket.!")
            }
        }).catch(err => console.log(err))


    }

    function renderButton() {
        if (isLoggedIn) {
            return <button className="ticket-button" onClick={handleClick}>Cancel Ticket {ticketId}</button>
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
