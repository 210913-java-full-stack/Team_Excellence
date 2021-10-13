import React, { useState } from 'react';
// import axios from 'axios';
import PropTypes from "prop-types";
import './CustomerLoginPage.css';




async function loginUser(credentials) {


    return await fetch('http://localhost:8080/api/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',

        },
        body: JSON.stringify(credentials)
    });



}


export default function CustomerLoginPage({ setToken }) {
    const [username, setUserName] = useState();
    const [password, setPassword] = useState();


    const handleSubmit = async (e) => {
        e.preventDefault();
        const result = await loginUser({
            username: username,
            password: password
        });
        let t = result.json();
        let token = JSON.parse(t);
        setToken(prev => prev = token);
        console.log(t);
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

CustomerLoginPage.propTypes = {
    setToken: PropTypes.func.isRequired,

}


    // async function loginUser(credentials) {
    //     return fetch('http://localhost:8080/api/login', {
    //         method: 'POST',
    //         headers: {
    //             'Content-Type': 'application/json',
    //             'Accept': 'application/json'
    //         },
    //         body: JSON.stringify(credentials)
    //     })
    //         .then(response => {

    //             if(response.ok){

    //             }


    //         }).catch((error) => {
    //             console.error(error);
    //         });

    // }