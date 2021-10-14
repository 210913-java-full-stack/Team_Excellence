import React from "react";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import CustomerLoginPage from "../Page/CustomerLoginPage";
import HomePage from "../Page/HomePage";

export default function CustomSwitchRouter() {




    return (
        <Router>
            <Switch>
                {/* the home path route needs the exact keyword or all request will get HomePage */}
                <Route exact path='/' component={HomePage} />
                <Route path='/login' component={CustomerLoginPage} />
            </Switch>
        </Router>
    );

}