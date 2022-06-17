import React from "react";
import { Link } from "react-router-dom";

export default function RoommateLink(props){
return(<Link to={`/roommates/${props.id}`} firstName={props.firstName}>
<div style={{"backgroundColor":"pink"}}>
<h3>{props.firstName} {props.lastName}</h3>
<p>{props.email}</p>


</div>


</Link>)


}