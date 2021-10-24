import React, { useState } from "react";
import AdminLoginPage from "./AdminLoginPage";


export default function AdminHomePage() {

    const [loggedIn, setLoggedIn] = useState(false)

    if (loggedIn) {
        return (
            <div>
                <h1>This is the Admin Home page.</h1>
            </div>
        );
    } else {
        return <AdminLoginPage setLoggedIn={setLoggedIn} />;
    }
}