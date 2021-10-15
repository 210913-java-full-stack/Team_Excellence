import React, { useState } from 'react';
import './EmployeeLoginPage.css';

export default function Login() {
    /*Create variables for username and password and initializing them with the useState hook. Provides the current 
    value of the variable you want to store in the state and gives you a function to set the new value.*/
    const [username, setUserName] = useState ("");
    const [password, setPassword] = useState ("");

    //Setting minimum and maximum username and password lengths. Does not check if the username and password match.
    function validateForm() {
        return username.length >= 3 && username.length <= 20 && password.length >= 8 && password.length <= 20;
    }

    //Used to disable the login button if the user inputs an invalid username or password.
    function handleSubmit(event) {
        event.preventDefault();
        // const result = await loginUser({
        //     username: username,
        //     password: password
        // });
    }

    //Creating the header and the login form.
    return (
        <div className="login">
            <h1>Employee Login</h1>
            <form className="login-form" onSubmit={handleSubmit}>
                <label>
                    <p>Username</p>
                    <input type="text" onChange={(e) => setUserName(e.target.value)} />
                </label> 
                <label>
                <p>Password</p>
                    <input type="text" onChange={(e) => setPassword(e.target.value)} />
                </label>
                <div>
                <button id="login-btn" type="submit" disabled={!validateForm()}>Login</button>             
                </div>  
            </form>
        </div>
    );
}