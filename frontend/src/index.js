import React from 'react';
import ReactDOM from 'react-dom/client';
import "bootstrap";
import './index.css';
import Navbar from './components/Navbar';
import Home from './components/Home';
import Footer from './components/Footer';
import Signup from './components/Signup';
import Login from './components/Login';
import Search from './components/Search';
import {
  BrowserRouter,
  Routes,
  Route,
} from "react-router-dom";
import MyProfile from './components/MyProfile';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
<> 
<BrowserRouter><Navbar/>
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="signup" element={<Signup />} />
      <Route path="login" element={<Login />} />
      <Route path="myprofile" element={<MyProfile />} />
      <Route path="search" element={<Search />} />
    </Routes><Footer />
  </BrowserRouter>
</>
);

