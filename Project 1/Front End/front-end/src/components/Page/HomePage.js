import React, { Component } from "react";
import NavigationBar from "../utils/NavigationBar";

export default class HomePage extends Component {


    render() {
        return (
            <div>
                <NavigationBar className="HomePage" />
                <h1>HomePage</h1>
            </div>
        );
    }
}