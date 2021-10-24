import React from 'react';
import "./AdminDashboard.css";
import AdminFlights from './AdminFlights';








export default function AdminDashboard() {



    /**
     * 
     * 
     * 
     */






    return (

        <section className="admin-dashboard">
            <div className="flights">
                <AdminFlights />
            </div >
            <div className="check-in">
                <div className="container">
                    <h2>Schedule a new Flight</h2>
                    <p>To Do List</p>
                    <ul>
                        <li>Schedule a new flight</li>
                        <li>show a flight has taken off</li>
                        <li>cancel a flight</li>
                        <li>view a flight manifest</li>
                        <li>cancel a ticket on any flight</li>
                    </ul>
                </div>
            </div>




        </section >

    );


}