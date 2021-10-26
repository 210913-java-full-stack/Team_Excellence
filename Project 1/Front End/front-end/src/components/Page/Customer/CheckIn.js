import React, { useState } from 'react';
import "./CheckIn.css";

function CheckIn() {

    const [ticketId, setTicketId] = useState()


    async function handleSubmit() {
        console.log("ticket ID: ", ticketId);
        
        fetch(`http://localhost:8080/api/ticket?ticketId=${ticketId}`, {
            method: "PUT"
        }).then((response) => {
            if (response.ok) {
                alert("You have checked In!")
            } else {
                alert("That's an invalid ticket number!")
            }
        })
    }

    return (
        <div className="check-in-screen">
            <h1>Check In Here!</h1>

            <div className="enter-ticket">
                <form >
                    <div>
                        <label>Enter your ticket number:</label>
                    </div>
                    <div>
                        <input type="text" onChange={e => setTicketId(e.target.value)} required ></input>
                    </div>
                    <button className="ticket-button" onClick={handleSubmit}>Check In</button>
                </form>

            </div>
        </div>
    );
}

export default CheckIn;