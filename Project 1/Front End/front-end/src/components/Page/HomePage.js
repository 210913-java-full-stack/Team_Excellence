import React, { useState } from "react";
import NavigationBar from "../utils/NavigationBar";
import './HomePage.css';

function HomePage() {

    const [token, setToken] = useState('');

    function tokerView() {
        if (token !== '') {
            return <h1 className="token">{token}</h1>;
        } else {
            return <h1 className="token">No token is set</h1>;
        }
    }

    return (
        <div>
            <NavigationBar setToken={setToken} token={token} />
            {tokerView()}




        </div>
    );
}

export default HomePage;