import React, { Component } from "react";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import PilotLoginPage from "../Page/PilotLoginPage";
import PilotHomePage from "../Page/PilotHomePage";


export default class CustomSwitchRouter extends Component {



    render() {
        return (
            <Router>
                <Switch>
                    {/* the pilot login path route needs the exact keyword or all request will get PilotLoginPage */}
                    <Route exact path='/Pilot' component={PilotLoginPage} />
                    <Route path='/pilot-home' component={PilotHomePage} />
                </Switch>
            </Router>
        );
    }
}