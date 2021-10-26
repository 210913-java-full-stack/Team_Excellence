import React, { useState } from 'react';
import "./AdminDashboard.css";
import AdminFlightDetail from './AdminFlightDetail';
import AdminFlights from './AdminFlights';
import CreateFlight from './CreateFlight';








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
                    <CreateFlight controlCreatePage={controlCreatePage} />
                </div>
            );
        } else if (flightPage && !createPage) {
            return (
                <div>
                    <button className="admin-back" onClick={controlFlightPage}>back</button>
                    <div className="admin-dashboard">

                        <div className="flights">

                            <AdminFlightDetail flightId={flightId} controlFlightPage={controlFlightPage} />
                        </div>
                    </div>
                </div>
            );


        } else {
            return (
                <div className="admin-dashboard">
                    <div className="flights">
                        <AdminFlights controlCreatePage={controlCreatePage} controlFlightPage={controlFlightPage} setFlightId={setFlightId} />

                    </div >
                </div >
            );
        }
    }


    return (

        <div>
            {renderFlights()}
        </div>

    );


}