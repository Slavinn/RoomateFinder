import React from "react"

export default function Home(){
    return (<main>
<h1>Home Page</h1>
<div className="desc-container">
<p>Welcome to our website. This platform is meant to help people finding their desired roommates. You can view people looking for a roommate and leave review about their personality! Go to signup page to create an account and find your perfect roommate. </p></div>
<div className="pictures">
    <div className="picture"><img src="./images/hobo1.jpeg" className="home-img"/><p className="home-title">Find a Roommate</p></div>
    <div className="picture"><img src="./images/hobo2.jpeg" className="home-img"/><p className="home-title">Contact Now</p></div>
    <div className="picture"><img src="./images/hobo3.jpeg" className="home-img"/><p className="home-title">We are here to help</p></div>
</div>
    </main>)
}