import React from "react";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

import HomePage from "../Page/Customer/HomePage";
import EmployeeLoginPage from "../Page/Employee/EmployeeLoginPage"


export default function CustomSwitchRouter() {

        return (
            <Router>
                <Switch>
                    {/* the home path route needs the exact keyword or all request will get HomePage */}
                    <Route exact path='/' component={HomePage} />
                    <Route exact path='/employee' component={EmployeeLoginPage} />
                </Switch>
            </Router>
        );
}