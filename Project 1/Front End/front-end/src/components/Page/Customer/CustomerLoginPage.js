import React, { useState } from 'react';

import './CustomerLoginPage.css';







export default function CustomerLoginPage({ setId, setRealUsername, setFirstName, setLastName, clickLogin, setIsLoggedIn, setNavLoggedIn }) {
    const [username, setUserName] = useState();
    const [password, setPassword] = useState();

    async function loginUser(credentials) {


        return await fetch('http://localhost:8080/api/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',

            },
            body: JSON.stringify(credentials)
        }
        ).then((response) => response.json()
        ).then(data => {
            setId(data["id"])
            setRealUsername(data["username"])
            setFirstName(data["firstName"])
            setLastName(data["lastName"])
            setIsLoggedIn(true)
            setNavLoggedIn(true)
        }).catch(error => console.log(error));

    }








    const handleSubmit = async (e) => {
        e.preventDefault();
        const result = await loginUser({
            username: username,
            password: password
        });
        clickLogin()
        console.log(result)

    }




    return (
        <div className="login-wrapper">
            <h1>Please Log In</h1>
            <form className="login-form" onSubmit={handleSubmit}>
                <div className="login-user">
                    <label>
                        <p>Username :</p>
                        <input type="text" onChange={e => setUserName(e.target.value)} />
                    </label>
                </div>
                <div className="login-pword">
                    <label>
                        <p>Password :</p>
                        <input type="password" onChange={e => setPassword(e.target.value)} />
                    </label>
                </div>
                <div className="login-submit">
                    <button id="login-btn" type="submit">Login</button>
                </div>
            </form>
        </div>
    )
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