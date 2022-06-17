import React, { useState } from "react";
import { useLocation } from "react-router-dom";
import Review from "./Review";
import TutorialDataService from "../TutorialDataService";
export default function MyProfile(props) {
  const [current_user,setCurrent_user]=useState({})
  const { state } = useLocation();
  if(state){
  localStorage.setItem("id",state.id);
  localStorage.setItem("user",state.firstName);
  localStorage.setItem("lastName",state.lastName);
  localStorage.setItem("summary",state.summary);
  localStorage.setItem("email",state.email);
  for(var i=0;i>state.reviews.length;i++){
    localStorage.setItem(`review${i}`,`Written by ${state.reviews[i].user}
    ${state.reviews[i].review}`)
  }
  }
console.log(JSON.stringify(current_user))

    console.log(current_user)
  // const reviews= current_user[localStorage.getItem("id")].reviews.map(x=><Review user={x.user} review={x.review} star={x.star}/>)
  return <div style={{"textAlign":"center"}}>
    <h1>{localStorage.getItem("user")} {localStorage.getItem("lastName")}</h1>
    <p>{localStorage.getItem("summary")}</p>
    <h3>email: {localStorage.getItem("email")}</h3>
    <h2>Edit User Info</h2>
    <form>
      <textarea placeholder="Enter Summary" defaultValue={localStorage.getItem("summary")} style={{"width":"100%","height":"50px"}}
     />
       <input placeholder="Email" type="email"/>
    <input type="submit" className="submit-btn"/>
    </form>
  </div>;
}
