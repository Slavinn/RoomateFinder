import React,{ useState,useEffect }  from "react";
import RoommateLink from "./RoommateLink";
import TutorialDataService from "../TutorialDataService";

export default function Search(){
    const [users,setUser] = useState()
// useEffect(()=>{async function getData(){console.log("get into0000");
// TutorialDataService.getAllUsers()
//     .then(res=> 
//        { console.log("jjjjj");
//  setUser(res.data); return res}).then(data=> (data))};
// getData();},[])
TutorialDataService.getAllUsers().then(
    res=>setUser(res.data.map(x=><RoommateLink firstName={x.firstName} lastName={x.lastName} id={x.id} email={x.email}/>))
)
console.log(users)
    return (<div>
       
        <div className="search-form"> <h3>Search Users</h3>
        <input type="text"className="search-bar"placeholder="Enter a name"/>
            <button className="submit-btn">Search</button></div>
        <h1>Search Results</h1>
        <div className="results">{users}</div>


        
    </div>)

}