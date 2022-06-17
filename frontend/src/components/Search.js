import React,{ useState,useEffect }  from "react";

import TutorialDataService from "../TutorialDataService";

export default function Search(){
    const [users,setUser] = useState({
        "id": 0,
        "firstName":"",
        "lastName":"",
        "email":"",
        "summary":""
    })
// useEffect(()=>{async function getData(){console.log("get into0000");
// TutorialDataService.getAllUsers()
//     .then(res=> 
//        { console.log("jjjjj");
//  setUser(res.data); return res}).then(data=> (data))};
// getData();},[])
    TutorialDataService.getAllUsers().then(
        res=>setUser(res.data)
    )
    console.log(users)
    return (<div>
       
        <div className="search-form"> <h3>Search Users</h3>
        <input type="text"className="search-bar"placeholder="Enter a name"/>
            <button className="submit-btn">Search</button></div>
        <h1>Search Results</h1>
        <div className="results">{JSON.stringify(users)}</div>


        
    </div>)

}