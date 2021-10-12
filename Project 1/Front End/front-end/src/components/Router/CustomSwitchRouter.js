import React, { Component } from "react";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import HomePage from "../Page/HomePage";

export default class CustomSwitchRouter extends Component {



    render() {
        return (
            <Router>
                <Switch>
                    <Route path='/' component={HomePage} />
                </Switch>
            </Router>
        )
    }
}