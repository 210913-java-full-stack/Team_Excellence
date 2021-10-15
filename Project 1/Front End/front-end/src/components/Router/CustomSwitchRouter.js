import React from "react";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

import HomePage from "../Page/Customer/HomePage";
import AdminLoginPage from "../Page/Employee/AdminLoginPage";
import PilotLoginPage from "../Page/Employee/PilotLoginPage";


export default function CustomSwitchRouter() {

        return (
            <Router>
                <Switch>
                    {/* the home path route needs the exact keyword or all request will get HomePage */}
                    <Route exact path='/' component={HomePage} />
                    <Route exact path='/admin' component={AdminLoginPage} />
                    <Route exact path='/pilot' component={PilotLoginPage} />
                </Switch>
            </Router>
        );
}