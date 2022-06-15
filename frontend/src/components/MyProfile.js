import React from "react";

export default function MyProfile(){
return (<><div style={{"display":"flex"}}>
<img className="profile-img" src="./images/myImage.png"/>
<div className="info-container"> <h1>Example User</h1>
<p>vulputate mi sit amet mauris commodo quis imperdiet massa tincidunt nunc pulvinar sapien et ligula ullamcorper malesuada proin libero nunc consequat interdum varius sit amet mattis vulputate enim nulla aliquet porttitor lacus luctus accumsan tortor posuere ac ut consequat semper viverra nam libero justo laoreet sit amet cursus sit amet dictum sit amet justo donec enim diam vulputate ut pharetra sit amet aliquam id diam maecenas ultricies mi eget mauris pharetra et ultrices neque ornare aenean euismod elementum nisi quis eleifend quam adipiscing vitae proin sagittis nisl rhoncus mattis rhoncus urna neque viverra justo nec ultrices dui sapien eget mi</p>
<h2>Email: example@email.com</h2></div>

</div>
<h1>Update Information</h1>
<form><input type="text" placeholder="Enter New Email"/>
<textarea type="text" style={{"height":"200px","width":"100%"}}placeholder="Enter New Description"/>
<input type="submit" className="submit-btn"value="Apply Changes"/></form>
<h1>Reviews</h1></>)




}