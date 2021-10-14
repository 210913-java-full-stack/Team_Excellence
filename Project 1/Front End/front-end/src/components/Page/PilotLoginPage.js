import React, { useState } from 'react';
// import axios from 'axios';
import PropTypes from "prop-types";
import './PilotLoginPage.css';



export default function PilotLoginPage({ setToken }) {
    const [username, setUserName] = useState();
    const [password, setPassword] = useState();
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState("");


    async function loginUser(credentials) {
        return fetch('http://localhost:8080/api/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            },
            body: JSON.stringify(credentials)
        })
            .then(data => {

                console.log(data.json());
            }).catch((error) => {
                console.log(error);
            });

    }

    const handleSubmit = async () => {
        const token = await loginUser({
            username: username,
            password: password,
        });
        setToken(prev => prev = token);
    }
    return (
        <div className="login-wrapper">
            <h1>Please Log In</h1>
            <form className="login-form" onSubmit={handleSubmit}>
                <label>
                    <p>Username :</p>
                    <input type="text" onChange={e => setUserName(e.target.value)} />
                </label>
                <label>
                    <p>Password :</p>
                    <input type="password" onChange={e => setPassword(e.target.value)} />
                </label>
                <div>
                    <button id="login-btn" type="submit">Login</button>
                </div>
            </form>
        </div>
    )
}

PilotLoginPage.propTypes = {
    setToken: PropTypes.func.isRequired
}