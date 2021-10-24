import React, { useState } from "react";
import AdminLoginPage from "./AdminLoginPage";
import AdminDashboard from "./AdminDashboard";


export default function AdminHomePage() {
    //users State
    const [loggedIn, setLoggedIn] = useState(false)
    const [id, setId] = useState()
    const [RealUsername, setRealUsername] = useState()
    const [firstName, setFirstName] = useState()
    const [lastName, setLastName] = useState()

    if (loggedIn) {
        document.title = `${RealUsername} in Admin`;
    } else {
        document.title = "Admin";
    }
    function clickLogout() {
        setId(null)
        setFirstName(null)
        setRealUsername(null)
        setLastName(null)
        setLoggedIn(false)
    }




    if (loggedIn) {

        return (
            <div>
                <button className="admin-logout" onClick={clickLogout}>logout</button>

                <h1>{RealUsername} is logged into the Admin System.</h1>
                <AdminDashboard />
            </div>
        );
    } else {
        return <AdminLoginPage setLoggedIn={setLoggedIn} setId={setId} setRealUsername={setRealUsername} setFirstName={setFirstName} setLastName={setLastName} />;
    }
}