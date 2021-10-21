import React, { useState } from "react";
import NavigationBar from "../../utils/NavigationBar";
import CustomerDashboard from "./CustomerDashboard";
import './HomePage.css';

function HomePage() {


    const [isLoggedIn, setIsLoggedIn] = useState(false)
    const [id, setId] = useState()
    const [RealUsername, setRealUsername] = useState()
    const [firstName, setFirstName] = useState()
    const [lastName, setLastName] = useState()

    const [dashboardClass, setDashboardClass] = useState(true);

    function changeDashboard() {
        setDashboardClass(p => p = !p)
    }

    let db_class = dashboardClass ? "grid-1" : "grid-2";

    return (
        <div>
            <NavigationBar
                setId={setId}
                setRealUsername={setRealUsername}
                setFirstName={setFirstName}
                setLastName={setLastName}
                setIsLoggedIn={setIsLoggedIn}
                isLoggedIn={isLoggedIn}
                firstName={firstName}
                lastName={lastName}
                changeDashboard={changeDashboard} />


            <CustomerDashboard db_class={db_class} id={id} isLoggedIn={isLoggedIn} />








        </div>
    );
}

export default HomePage;