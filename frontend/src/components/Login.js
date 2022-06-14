import React from "react";


export default function Login(){
    return(<div><h1 style={{"textAlign":"center"}}>Login Form</h1>
    <form>
<label>Email</label>
<input type="text" placeholder="Email" id="log-email" name="log-email"/>
<label>Password</label>
<input type="text" placeholder="Password" id="log-password" name="log-password"/>
<input type="submit" className="submit-btn" name="Submit" value="Login"/>
</form></div>)

}