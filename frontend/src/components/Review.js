import React from "react";

export default function Review(props){
return(<div style={{"backgroundColor":"burlywood"}}>
    <p>Written by {props.user}</p>
    <p>{props.review}</p>
    <p>{props.star} stars</p>

</div>)


}