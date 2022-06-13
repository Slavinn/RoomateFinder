import React from "react"
import { Link } from "react-router-dom";

export default function Navbar(){
    return (<nav><img src="./room.png" className="navbar-icon"/>
        <Link to="/"><a href="#"><p className="navbar-title" >Roommate Finder</p></a></Link>
        
        <Link to="/login"><a href="#">Login</a></Link>
        <a href="#">Logout</a>
        <Link to="/signup"><a href="#">Signup</a></Link>
        <a href="#">Search Roommates</a>
        <Link to="/myprofile"><a href="#">My Profile</a></Link>
    </nav>)
} 