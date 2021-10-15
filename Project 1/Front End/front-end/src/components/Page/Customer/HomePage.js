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
                lastName={lastName} />


            <CustomerDashboard />








        </div>
    );
}

export default HomePage;