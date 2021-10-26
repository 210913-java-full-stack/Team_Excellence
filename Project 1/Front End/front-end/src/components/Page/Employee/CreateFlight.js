import React, { useState } from "react";



export default function CreateFlight({ controlCreatePage }) {
    const [depart, setDepart] = useState()
    const [departDate, setDepartDate] = useState()
    const [departTime, setDepartTime] = useState()
    const [arrive, setArrive] = useState()
    const [arriveDate, setArriveDate] = useState()
    const [arriveTime, setArriveTime] = useState()



    async function handleSubmit() {
        let json = {
            departLocation: depart,
            departDate: departDate,
            departTime: departTime,
            arriveLocation: arrive,
            arriveDate: arriveDate,
            arriveTime: arriveTime,
            takeOff: false
        }
        await fetch("http://localhost:8080/api/flight", {
            method: "POST",
            body: JSON.stringify(json)
        }).then(response => {
            if (response.ok) {
                alert("You've created the flight.")
            }
        }).catch(error => console.log(error));


        controlCreatePage();

    }

    return (
        <section>
            <h1>Create a Flight</h1>
            <form >
                <lable>Departure City</lable>
                <input type="text" onChange={e => setDepart(e.target.value)} required />
                <lable>Departure Date</lable>
                <input type="text" onChange={e => setDepartDate(e.target.value)} required />
                <lable>Departure Time</lable>
                <input type="text" onChange={e => setDepartTime(e.target.value)} required />
                <lable>Arrival City</lable>
                <input type="text" onChange={e => setArrive(e.target.value)} required />
                <lable>Arrival Date</lable>
                <input type="text" onChange={e => setArriveDate(e.target.value)} required />
                <lable>Arrival Time</lable>
                <input type="text" onChange={e => setArriveTime(e.target.value)} required />
                <button type="button" onClick={handleSubmit} >Submit</button>

            </form>
        </section>

    )
}

