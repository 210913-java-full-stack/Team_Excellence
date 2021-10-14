import React, { Component } from "react";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import CustomerLoginPage from "../Page/CustomerLoginPage";
import HomePage from "../Page/HomePage";

export default class CustomSwitchRouter extends Component {



    render() {
        return (
            <Router>
                <Switch>
                    {/* the home path route needs the exact keyword or all request will get HomePage */}
                    <Route exact path='/' component={HomePage} />
                    <Route path='/pilot' Component={PilotLoginPage} />
                    <Route path='/admin' Component={AdminLoginPage} />
                </Switch>
            </Router>
        );
    }
}