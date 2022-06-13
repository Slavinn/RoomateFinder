import React from "react"
import { Link } from "react-router-dom";

export default function Navbar(){
    return (<nav><img src="./room.png" className="navbar-icon"/>
        <Link to="/"><p className="navbar-title" >Roommate Finder</p></Link>
        
        <Link to="/login"><a href="#">Login</a></Link>
        <a href="#">Logout</a>
        <Link to="/signup"><a href="#">Signup</a></Link>
        <Link to="/search"><a href="#">Search Roommates</a></Link>
        <Link to="/myprofile"><a href="#">My Profile</a></Link>
    </nav>)
} 