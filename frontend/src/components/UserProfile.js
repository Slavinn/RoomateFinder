import TutorialDataService from "../TutorialDataService";
import { useParams } from 'react-router-dom';
import { useState,useEffect } from "react";
import Review from "./Review";

export default function UserProfile(){

    const { id } = useParams();
    const [user,setUser] = useState([])
    useEffect(()=>{async function getData(){TutorialDataService.getRoommateById(id)
    .then(res=> 
 setUser(res.data)).then(data=> (data))};
getData();},[id])

//this function is not working yet.
function sendReview(){
    let review = document.getElementById("review")
    TutorialDataService.createReview({"review":review.value,"user":"anon","star":4,"date":"today"})
}
var items = user.reviews?.map(x=><Review star={x.star} review={x.review} user={x.user}/>)

return (<div style={{"textAlign":"center"}}>
<h1>{user.firstName} {user.lastName}</h1>
<p>{user.summary}</p>
<h2>{user.email}</h2>
<h3>Write a Review</h3>
<div>
<select>
    <option className="star" value="5">5 stars</option>
    <option className="star" value="4">4 stars</option>
    <option className="star" value="3">3 stars</option>
    <option className="star" value="2">2 stars</option>
    <option className="star" value="1">1 star</option>
</select>
<textarea placeholder="Your Review" id="review" style={{"width":"100%","height":"200px","resize":"none"}}></textarea>
<button className="submit-btn" onClick={sendReview}>Send review</button></div>
<h2>Reviews</h2>
<div>{items}</div>
</div>) 


}