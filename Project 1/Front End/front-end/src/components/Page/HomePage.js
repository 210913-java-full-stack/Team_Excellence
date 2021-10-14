import React, { useState } from "react";
import NavigationBar from "../utils/NavigationBar";
import './HomePage.css';

function HomePage() {


    const [isLoggedIn, setIsLoggedIn] = useState(false)
    const [id, setId] = useState()
    const [RealUsername, setRealUsername] = useState()
    const [firstName, setFirstName] = useState()
    const [lastName, setLastName] = useState()


    function tokerView() {
        if (isLoggedIn) {
            return <h1 className="token">{RealUsername} has logged in.</h1>;
        } else {
            return <h1 className="token">No one is logged in.</h1>;
        }
    }

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

            {tokerView()}




        </div>
    );
}

export default HomePage;