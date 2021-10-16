import React, { useState } from 'react';
import './EmployeeLoginPage.css';
import AdminHomePage from './AdminHomePage';
import PilotHomePage from './PillotHomePage';

function AdminLoginPage() {
    /*Create variables for username and password and initializing them with the useState hook. Provides the current 
    value of the variable you want to store in the state and gives you a function to set the new value.*/
    const [username, setUserName] = useState ("");
    const [password, setPassword] = useState ("");
    const [realUsername, setRealUsername] = useState("");
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [isLoggedIn, setIsLoggedIn] = useState("");
    const [id, setId] = useState("");
    const showPassword = false;
    let employeeRole;

    //Setting minimum and maximum username and password lengths. Does not check if the username and password match.
    function validateForm() {
        return username.length >= 3 && username.length <= 20 && password.length >= 6 && password.length <= 20;
    }

        async function loginAdmin(credentials) {


            return await fetch('http://localhost:8080/api/admin', {
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
            }).catch(error => console.log(error));
    
        }
    
        function renderAdminHomePage () {
            if(isLoggedIn){
                return(
                    <AdminHomePage />
                );
            }
        
            }
        
        async function loginPilot(credentials) {


            return await fetch('http://localhost:8080/api/pilot', {
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
            }).catch(error => console.log(error));
    
        }
    
        function renderPilotHomePage () {
            if(isLoggedIn){
                return(
                    <PilotHomePage />
                );
            }
    
        }

    async function handleSubmit(e) {
        e.preventDefault();
        console.log(employeeRole);
        if(employeeRole === 0){
            await loginAdmin({
                username: username,
                password: password
            });
            renderAdminHomePage();
        } else if(employeeRole === 1) {
            await loginPilot({
                username: username,
                password: password
            });
        }
    }

    function userRole(role){
        if(role == 'Admin'){
            employeeRole = 0;
        } else if(role == 'Pilot'){
            employeeRole = 1;
        }
        return employeeRole;
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
                    <input type={showPassword ? "text" : "password"} onChange={(e) => setPassword(e.target.value)} />
                </label>
                <button type="submit" disabled={!validateForm()}>Login</button>            
            </form>
            <div className="Role">
                <button onClick="userRole('Admin')">
                    Admin
                </button>
                <div className="divider" />
                <button onClick="userRole('Pilot')">
                    Pilot
                </button>
            </div>
        </div>
    );
}

export default AdminLoginPage;