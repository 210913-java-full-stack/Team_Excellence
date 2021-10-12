import React, { Component } from "react";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import CustomerLoginPage from "../Page/CustomerLoginPage";
import HomePage from "../Page/HomePage";

export default class CustomSwitchRouter extends Component {



    render() {
        return (
            <Router>
                <Switch>
                    <Route exact path='/' component={HomePage} />
                    <Route path='/login' component={CustomerLoginPage} />
                </Switch>
            </Router>
        );
    }
}