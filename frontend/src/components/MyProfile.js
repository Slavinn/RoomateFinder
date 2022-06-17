import React, { useState } from "react";
import { useLocation } from "react-router-dom";
import Review from "./Review";
import TutorialDataService from "../TutorialDataService";
export default function MyProfile(props) {
  const { state } = useLocation();
  let keys = state.keys;
  console.log(state);
  localStorage.setItem("id",state.id);
  localStorage.setItem("user",state.firstName);
  //let current_user = TutorialDataService.getRoommateById(localStorage.getItem(id))
  const reviews= state.reviews.map(x=><Review user={x.user} review={x.review} star={x.star}/>)
  return <div style={{"textAlign":"center"}}>
    <h1>{state.firstName} {state.lastName}</h1>
    <p>{state.summary}</p>
    <h3>email: {state.email}</h3>
    <h2>Reviews</h2>
    {reviews}
  </div>;
}
