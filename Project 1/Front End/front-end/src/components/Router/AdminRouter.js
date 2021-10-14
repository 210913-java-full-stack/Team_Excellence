import React, { Component } from "react";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import AdminLoginPage from "../Page/AdminLoginPage";
import AdminHomePage from "../Page/AdminHomePage";


export default class CustomSwitchRouter extends Component {



    render() {
        return (
            <Router>
                <Switch>
                    {/* the admin login path route needs the exact keyword or all request will get AdminLoginPage */}
                    <Route exact path='/Admin' component={AdminLoginPage} />
                    <Route path='/admin-login' component={AdminHomePage} />
                </Switch>
            </Router>
        );
    }
}