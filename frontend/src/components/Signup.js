import React from "react";
import TutorialDataService from "../TutorialDataService";

export default function Signup(){


    function sendForm(){
        console.log("button clicked.")
        if(!(firstName.value&&lastName.value&&password.value&&password_con.value&&email.value))
        return console.log("Empty fields")
        else if(password.value!==password_con.value)
        return console.log("Passwords don't match")
        else{
    return TutorialDataService.createUser({"firstName":firstName.value,"lastName":lastName.value,"email":email.value,"password":password.value,"summary":""})}
    }
    let firstName = document.getElementById("fname");
    let lastName = document.getElementById("lname");
    let email = document.getElementById("email");
    let password = document.getElementById("password");
    let password_con = document.getElementById("password-con");


    return(<div><h1 style={{"textAlign":"center"}}>Signup Form</h1>
    <form>
	<label for="fname">First Name</label>
<input type="text" placeholder="First Name" id="fname" name="fname"/>
<label for="lname">Last Name</label>
<input type="text" placeholder="Last Name" id="lname" name="lname"/>
<label for="email">Email</label>
<input type="text" placeholder="Email" id="email" name="email"/>
<label for="password">Password</label>
<input type="password" placeholder=" Enter Password" id="password" name="password"/>
<input type="password" placeholder="Confirm Password" id="password-con" name="password-con"/>
<div className="submit-btn" name="Submit" value="Signup" onClick={sendForm}>Submit</div>
</form></div>)

}