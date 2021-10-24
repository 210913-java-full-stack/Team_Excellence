import React, { useState } from 'react';
import "./AdminDashboard.css";
import AdminFlights from './AdminFlights';








export default function AdminDashboard() {

    const [createPage, setCreatePage] = useState(false)
    const [flightPage, setFlightPage] = useState(false)
    const [flightId, setFlightId] = useState()



    function controlFlightPage() {
        setFlightPage(p => p = !p)
    }

    function controlCreatePage() {
        setCreatePage(p => p = !p)
    }

    function renderFlights() {
        if (createPage && !flightPage) {
            return (
                <div>
                    <button className="admin-logout" onClick={controlCreatePage}>back</button>
                    <h1>Create a flight</h1>
                </div>
            );
        } else if (flightPage && !createPage) {
            return (
                <div>
                    <button className="admin-logout" onClick={controlFlightPage}>back</button>
                    <h1>Flight Page for BCON{flightId}</h1>
                </div>
            );


        } else {
            return (
                <section className="admin-dashboard">
                    <div className="flights">
                        <AdminFlights controlCreatePage={controlCreatePage} controlFlightPage={controlFlightPage} setFlightId={setFlightId} />

                    </div >
                </section >
            );
        }
    }


    return (

        <div>
            {renderFlights()}
        </div>

    );


}