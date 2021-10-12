import React, { useState } from 'react';
// import CustomerLoginPage from '../Page/CustomerLoginPage';
import "./NavigationBar.css";



function NavigationBar() {

    const [menuOpen, setMenuOpen] = useState(false)

    function renderSideBar() {
        if (menuOpen) {
            return (
                <div className="menu" id="menu">
                    <ul>
                        <li className="menu-item">Login</li>
                        <li className="menu-item">Account</li>
                        <li className="menu-item">Flights</li>
                    </ul>
                </div>
            );
        }
    }




    function setMenuFalse() {
        setMenuOpen(prev => prev = false)
    }

    function setMenuTrue() {
        setMenuOpen(prev => prev = true)
    }

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
                            <button type="button" className="menu-btn" onClick={menuOpen ? setMenuFalse : setMenuTrue}>
                                <img alt="menu" className="menu-button" src="https://img.icons8.com/ios/50/000000/menu--v1.png" />
                            </button>
                        </div>
                    </li>
                    <li >
                        <div className="login">

                            <a href="http://localhost:3000/login" > Login</a>



                        </div>
                    </li>

                </ul>
            </nav>

        </div >
    );

}

export default NavigationBar;
