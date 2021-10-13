import React, { useState } from 'react';
import CustomerLoginPage from '../Page/CustomerLoginPage';
import "./NavigationBar.css";



function NavigationBar() {
    const [token, setToken] = useState('')
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState("");

    const [menuOpen, setMenuOpen] = useState(false)
    const [loginScreen, setLoginScreen] = useState(false)

    function renderSideBar() {
        if (menuOpen) {
            return (
                <div className="menu" id="menu">
                    <ul>
                        <li className="menu-item"><button onClick={clickLogin}>Login</button></li>
                        <li className="menu-item">Account</li>
                        <li className="menu-item">Flights</li>
                    </ul>
                </div>
            );
        }
    }




    function clickLogin() {
        if (loginScreen) {
            setLoginScreen(p => p = false)
        } else {
            setLoginScreen(p => p = true)
        }
    }


    function clickMenu() {
        if (menuOpen) {
            setMenuOpen(p => p = false)
        } else {
            setMenuOpen(p => p = true)
        }
    }

    if (!token) {
        if (!loginScreen) {
            return (
                <div>
                    <nav className="header">
                        <ul>

                            <li>
                                {renderSideBar()}
                            </li>

                            <li >
                                <h1>BRITCON air</h1>
                            </li>

                            <li className="menu-button">
                                <div id="menu-btn">
                                    <button type="button" className="menu-btn" onClick={clickMenu}>
                                        <img alt="menu" className="menu-button" src="https://img.icons8.com/ios/50/000000/menu--v1.png" />
                                    </button>
                                </div>
                            </li>
                            <li >
                                <div className="login">

                                    <button type="button" className="login-btn" onClick={clickLogin} >Login</button>



                                </div>
                            </li>

                        </ul>
                    </nav>

                </div >
            );

        } else {
            return (
                <div id="login-render">
                    <CustomerLoginPage setToken={setToken} onSubmit={clickLogin} />
                    <div className="back">
                        <button className="back-to-home" onClick={clickLogin} >back </button>
                    </div>
                </div>
            );
        }
    } else {
        <div>
            <nav className="header">
                <ul>

                    <li>
                        {renderSideBar()}
                    </li>

                    <li >
                        <h1>BRITCON air</h1>
                    </li>

                    <li className="menu-button">
                        <div id="menu-btn">
                            <button type="button" className="menu-btn" onClick={clickMenu}>
                                <img alt="menu" className="menu-button" src="https://img.icons8.com/ios/50/000000/menu--v1.png" />
                            </button>
                        </div>
                    </li>
                    <li >
                        <div className="login">
                            {/* need to change the onClick to handle account Screen  */}
                            <button type="button" className="login-btn" onClick={clickLogin} >{firstName} {lastName}</button>



                        </div>
                    </li>

                </ul>
            </nav>

        </div >
    }

}

export default NavigationBar;
