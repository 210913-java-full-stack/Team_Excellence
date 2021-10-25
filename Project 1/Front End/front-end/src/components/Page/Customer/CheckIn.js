import React, { useState } from 'react';
import "./CheckIn.css";

function CheckIn() {

    const [ticketId, setTicketId] = useState('');


    async function handleSubmit() {
        alert("ticket ID: ", ticketId);
        let response = await fetch(`http://localhost:8080/api/ticket?ticketId=${ticketId}`, {
            method: "PUT"
        })
        alert("ticket ID: ", ticketId);
        await respAlert(response);    
        alert("ticket ID: ", ticketId);  

        // fetch(`http://localhost:8080/api/ticket?ticketId=${ticketId}`, {
        //     method: "PUT"
        // }).then((response) => {
        //     if (response.ok) {
        //         alert("You have checked In!")
        //     } else {
        //         alert("That's an invalid ticket number!")
        //     }
        // })
    }

    function respAlert(resp) {
        console.log(resp);
        alert(resp);
        if(resp.ok) {
            alert("logged in!");
        } else {
            alert("That's an invalid ticket number!");
        }
    }

    function testChange(e) {

        console.log("event: ", e.target.value);
        setTicketId(e.target.value);
        console.log("state: ", ticketId);
        
        alert("test");
    }

    return (
        <div className="check-in-screen">
            <h1>Check In Here!</h1>

            <div className="enter-ticket">
                <form onSubmit={handleSubmit}>
                    <div>
                        <label>Enter your ticket number:</label>
                    </div>
                    <div>
                        <input type="text" value={ticketId} onChange={(e) => testChange(e)} required ></input>
                    </div>
                    <button className="ticket-button" type="submit">Check In</button>
                </form>

            </div>
        </div>
    );
}

export default CheckIn;