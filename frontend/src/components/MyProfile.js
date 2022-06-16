import React, { useState } from "react";
import { useLocation } from "react-router-dom";

export default function MyProfile(props) {
  const [user, setUser] = useState({});
  const { state } = useLocation();
  console.log(state);
  return <div></div>;
}
