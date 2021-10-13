import React, { useState } from 'react';
// import axios from 'axios';
import PropTypes from "prop-types";
import './CustomerLoginPage.css';



export default function CustomerLoginPage({ setToken }, updateCallback) {
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
            }).finally()

    }

    const handleSubmit = async (e) => {
        e.preventDefault();
        const token = await loginUser({
            username: username,
            password: password,
        });
        setToken(prev => prev = token);
        console.log(token);
        updateCallback = false;

    }
    return (
        <div className="login-wrapper">
            <h1>Please Log In</h1>
            <form method="post" action="http://localhost:8080/api/login">
                <label>
                    <p>Username :</p>
                    <input type="text" name="username" />
                </label>
                <label>
                    <p>Password :</p>
                    <input type="password" name="password" />
                </label>
                <div>
                    <button id="login-btn" type="submit">Login</button>
                </div>
            </form>
        </div>
    )
}

CustomerLoginPage.propTypes = {
    setToken: PropTypes.func.isRequired
}