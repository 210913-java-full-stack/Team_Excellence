import React, { useState } from 'react';
import CustomerLoginPage from '../Page/Customer/CustomerLoginPage';

import "./NavigationBar.css";



function NavigationBar({ setId, setRealUsername, setFirstName, setLastName, setIsLoggedIn, isLoggedIn, firstName, lastName, changeDashboard }) {




    const [loginScreen, setLoginScreen] = useState(false)


    function clickLogout() {
        setId(p => p = null)
        setRealUsername(p => p = null)
        setFirstName(p => p = null)
        setLastName(p => p = null)
        setIsLoggedIn(p => p = false)
    }



    function clickLogin() {
        if (loginScreen) {
            setLoginScreen(p => p = false);

        } else {
            setLoginScreen(p => p = true);

        }
        changeDashboard();
    }


    function renderNotLoggedin() {
        if (loginScreen) {
            return (
                <div id="login-render">
                    <CustomerLoginPage
                        setId={setId}
                        setRealUsername={setRealUsername}
                        setFirstName={setFirstName}
                        setIsLoggedIn={setIsLoggedIn}
                        setLastName={setLastName}
                        clickLogin={clickLogin} />
                    <button className="back-to-home" onClick={clickLogin} >back </button>
                </div>
            );
        } else {

            return (
                <div>
                    <nav className="header">
                        <ul>

                            <li >
                                <h1>GAUTIER AIRLINES</h1>
                            </li>


                            <li >
                                <div className="login">

                                    <button type="button" className="login-button" onClick={clickLogin} >Login</button>



                                </div>
                            </li>

                        </ul>
                    </nav>

                </div >
            );
        }
    }


    function renderLoggedIn() {
        return (
            <div>
                <nav className="header">
                    <ul>



                        <li >
                            <h1>GAUTIER AIRLINES</h1>
                        </li>


                        <li >
                            <div className="login">

                                <span>{firstName} {lastName}</span>
                                <button className="login-button" type="button" onClick={clickLogout} >Logout</button>



                            </div>
                        </li>

                    </ul>
                </nav>

            </div >
        );
    }

    if (isLoggedIn) {

        return (
            <div>
                {renderLoggedIn()}


            </div>
        );
    } else {
        return (
            <div>
                {renderNotLoggedin()}

            </div>
        );

    }





}





export default NavigationBar;
