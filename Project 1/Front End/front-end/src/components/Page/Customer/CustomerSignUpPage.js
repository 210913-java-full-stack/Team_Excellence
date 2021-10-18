import React, { useState } from 'react';







function CustomerSignUpPage({ clickSignUp }) {
    const [firstName, setFirstName] = useState()
    const [lastName, setLastName] = useState()
    const [username, setUsername] = useState()
    const [password, setPassword] = useState()
    const [email, setEmail] = useState()

    async function signUp(credentials) {
        return await fetch("http://localhost:8080/api/customer", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',

            },
            body: JSON.stringify(credentials)

        }).catch(error => console.log(error));
    }

    const handleSubmit = async (e) => {
        e.preventDefault();
        const result = await signUp({
            username: username,
            password: password,
            email: email,
            firstName: firstName,
            lastName: lastName
        });
        clickSignUp()
        console.log(result)

    }



    return (
        <div>
            <h1>Sign up</h1>
            <form className="login-form" onSubmit={handleSubmit}>
                <label>
                    <p>First Name:</p>
                    <input type="text" onChange={e => setFirstName(e.target.value)} />
                </label>
                <label>
                    <p>Last Name:</p>
                    <input type="text" onChange={e => setLastName(e.target.value)} />
                </label>
                <label>
                    <p>Email:</p>
                    <input type="text" onChange={e => setEmail(e.target.value)} />
                </label>
                <label>
                    <p>Username :</p>
                    <input type="text" onChange={e => setUsername(e.target.value)} />
                </label>

                <label>
                    <p>Password :</p>
                    <input type="password" onChange={e => setPassword(e.target.value)} />
                </label>

                <div className="login-submit">
                    <button id="login-btn" type="submit">SignUp</button>
                </div>
            </form>
        </div>
    );


}


export default CustomerSignUpPage;