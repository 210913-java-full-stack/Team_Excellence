import React, { useState } from 'react';
import './EmployeeLoginPage.css';



function AdminLoginPage({ setLoggedIn, setFirstName, setId, setRealUsername, setLastName }) {
    /*Create variables for username and password and initializing them with the useState hook. Provides the current 
    value of the variable you want to store in the state and gives you a function to set the new value.*/
    const [username, setUserName] = useState("");
    const [password, setPassword] = useState("");



    //Setting minimum and maximum username and password lengths. Does not check if the username and password match.

    async function loginAdmin(credentials) {


        return await fetch('http://localhost:8080/api/admin-login', {
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
            setLoggedIn(true)
        }).catch(error => {
            alert("invalid username or password");
            console.log(error)
        });

    }



    const handleSubmit = async (e) => {
        e.preventDefault();
        const result = await loginAdmin({
            username: username,
            password: password
        });

        console.log(result)

    }

    //Creating the header and the login form. Login button is disabled if an invalid username or password is entered.
    return (
        <div className="employee-login">
            <h1>Admin Login</h1>
            <form className="employee-login-form" onSubmit={handleSubmit}>
                <label>
                    <p>Username</p>
                    <input type="text" onChange={(e) => setUserName(e.target.value)} />
                </label>
                <label>
                    <p>Password</p>
                    <input type="password" onChange={(e) => setPassword(e.target.value)} />
                </label>
                <button className="admin-logout" type="submit" >Login</button>
            </form>
        </div>
    );
}

export default AdminLoginPage;