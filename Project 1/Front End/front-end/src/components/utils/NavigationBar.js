import React from 'react';
import "./NavigationBar.css";


export default class NavigationBar extends React.Component {

    static defaultProps = {
        menuOpen: false,
    }
    constructor(props) {
        super(props);
        this.state = {
            menuOpen: this.props.menuOpen,
        }

        this.renderSideBar = this.renderSideBar.bind(this);
        this.setMenuFalse = this.setMenuFalse.bind(this);
        this.setMenuTrue = this.setMenuTrue.bind(this);
    }

    setMenuFalse() {
        this.setState({ menuOpen: false });
    }

    setMenuTrue() {
        this.setState({ menuOpen: true });
    }




    renderSideBar() {
        if (this.state.menuOpen) {
            return (
                <div className="menu" id="menu">
                    <ul>
                        <li className="menu-item">Login</li>
                        <li className="menu-item">Account</li>
                        <li className="menu-item">Flights</li>
                    </ul>
                </div>
            );
        }
    }


    render() {





        return (
            <div>
                <nav className="header">
                    <ul>

                        <li>
                            {this.renderSideBar()}
                        </li>

                        <li className="menu-title">
                            <h1>BRITCON air</h1>
                        </li>

                        <li className="menu-button">
                            <div id="menu-btn">
                                <button type="button" className="menu-button" onClick={this.state.menuOpen ? this.setMenuFalse : this.setMenuTrue}>
                                    <img alt="menu" className="menu-button" src="https://img.icons8.com/ios/50/000000/menu--v1.png" />
                                </button>
                            </div>
                        </li>
                        <li className="login">
                            Login
                        </li>

                    </ul>
                </nav>
            </div >
        );

    }
}