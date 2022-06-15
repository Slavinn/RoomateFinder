import React from "react"
import { Link } from "react-router-dom";

export default function Navbar(){
    return (<nav><img src="./room.png" className="navbar-icon"/>
        <Link to="/"><p className="navbar-title" >Roommate Finder</p></Link>
        
        <Link to="/login"><a href="frontend/src/components/Navbar#">Login</a></Link>
        <a href="frontend/src/components/Navbar#">Logout</a>
        <Link to="/signup"><a href="frontend/src/components/Navbar#">Signup</a></Link>
        <Link to="/search"><a href="frontend/src/components/Navbar#">Search Roommates</a></Link>
        <Link to="/myprofile"><a href="frontend/src/components/Navbar#">My Profile</a></Link>
    </nav>)
} 