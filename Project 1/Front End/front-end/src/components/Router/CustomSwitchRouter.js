import React from "react";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

import HomePage from "../Page/Customer/HomePage";
import AdminHomePage from "../Page/Employee/AdminHomePage";


import YouPurchasedTickets from "../Page/YouPurchasedTickets";


export default function CustomSwitchRouter() {

    return (
        <Router>
            <Switch>
                {/* the home path route needs the exact keyword or all request will get HomePage */}
                <Route exact path='/' component={HomePage} />
                <Route path='/admin' component={AdminHomePage} />
                <Route path="/ticket" component={YouPurchasedTickets} />
            </Switch>
        </Router>
    );
}