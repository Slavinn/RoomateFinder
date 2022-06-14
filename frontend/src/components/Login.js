import React from "react";


export default function Signup(){
    return(<div><h1 style={{"textAlign":"center"}}>Login Form</h1>
    <form>
<label for="log-email">Email</label>
<input type="text" placeholder="Email" id="log-email" name="log-email"/>
<label for="log-password">Password</label>
<input type="text" placeholder="Email" id="log-password" name="log-password"/>
<input type="submit" className="submit-btn" name="Submit" value="Login"/>
</form></div>)

}