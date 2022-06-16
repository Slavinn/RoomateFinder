import React from "react";
import { Link } from "react-router-dom";
import AuthenticationService from "../AuthenticationService";

export default function Navbar() {
  return (
    <nav>
      <img src="./room.png" className="navbar-icon" />
      <Link to="/">
        <p className="navbar-title">Roommate Finder</p>
      </Link>

      <Link to="/login">
        <a href="frontend/src/components/Navbar#">Login</a>
      </Link>
      <Link to="/logout">
        <a
          href="frontend/src/components/Navbar#"
          onClick={AuthenticationService.logout}
        >
          Logout
        </a>
      </Link>
      <Link to="/signup">
        <a href="frontend/src/components/Navbar#">Signup</a>
      </Link>
      <Link to="/search">
        <a href="frontend/src/components/Navbar#">Search Roommates</a>
      </Link>
      <Link to="/myprofile">
        <a href="frontend/src/components/Navbar#">My Profile</a>
      </Link>
    </nav>
  );
}
