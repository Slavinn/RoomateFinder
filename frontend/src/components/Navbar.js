import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import AuthenticationService from "../AuthenticationService";

export default function Navbar(props) {
const [loggedIn,setIsLoggedIn]=useState(AuthenticationService.isUserLoggedIn());


  return (
    <nav>
      <img src="./room.png" className="navbar-icon" />
      <Link to="/" className="navbar-title">
        Roommate Finder
      </Link>
    {!loggedIn&&
      <><Link to="/login" >
      Login
      </Link>
       <Link to="/signup">
        Signup
      </Link></>}

      {loggedIn &&
     <> <Link to="/logout"  onClick={()=>{AuthenticationService.logout();
     setIsLoggedIn(false)}}>
          Logout
      </Link>
      <Link to="/search">
      Search Roommates
      </Link>
      <Link to="/myprofile">
        My Profile
      </Link></>}
    </nav>
  );
}
