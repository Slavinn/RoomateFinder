import React from "react";

export default function Search(){
    return (<div>
       
        <div className="search-form"> <h3>Search Users</h3>
        <input type="text"className="search-bar"placeholder="Enter a name"/>
            <button className="submit-btn">Search</button></div>
        <h1>Search Results</h1>
        <div className="results"></div>


        
    </div>)

}