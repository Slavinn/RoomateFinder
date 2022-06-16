import React from "react";
import ReactDOM from "react-dom/client";
import "bootstrap";
import "./index.css";
import Navbar from "./components/Navbar";
import Home from "./components/Home";
import Footer from "./components/Footer";
import Signup from "./components/Signup";
import Login from "./components/Login";
import Logout from "./components/Logout";
import Search from "./components/Search";
import MyProfile from "./components/MyProfile";
import UserProfile from "./components/UserProfile";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import AuthenticatedRoute from "./AuthenticationRoute";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <>
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route
          path="roommates/:id"
          element={
            <AuthenticatedRoute>
              <UserProfile />
            </AuthenticatedRoute>
          }
        />
        <Route path="/" element={<Home />} />
        <Route
          path="/logout"
          element={
            <AuthenticatedRoute>
              <Logout />
            </AuthenticatedRoute>
          }
        />
        <Route path="signup" element={<Signup />} />
        <Route path="login" element={<Login />} />
        <Route
          path="myprofile"
          element={
            <AuthenticatedRoute>
              <MyProfile />
            </AuthenticatedRoute>
          }
        />
        <Route
          path="search"
          element={
            <AuthenticatedRoute>
              <Search />
            </AuthenticatedRoute>
          }
        />
      </Routes>
      <Footer />
    </BrowserRouter>
  </>
);
