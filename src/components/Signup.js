import React from "react";


export default function Signup(){
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
<input type="submit" className="submit-btn" name="Submit" value="Signup"/>
</form></div>)

}