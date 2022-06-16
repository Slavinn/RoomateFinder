import { useState } from "react";
import AuthenticationService from "../AuthenticationService";
import { Route, useNavigate } from "react-router-dom";
import DataStorage from "../DataStorage";

const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [loginMessage, setLoginMessage] = useState("");
  let navigate = useNavigate();

  const handleEmailChange = (event) => {
    setEmail(event.target.value);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    AuthenticationService.executeJwtAuthenticationService(email, password)
      .then((response) => {
        isValidLogin(true);
        AuthenticationService.registerSuccessfulLoginForJwt(
          email,
          response.data.jwtTokenResponse.token
        );

        navigate(`/myprofile`, { state: { ...response.data.roommate } });
      })
      .catch((error) => {
        isValidLogin(false);
      });
  };

  const isValidLogin = (valid) =>
    setLoginMessage(
      valid ? (
        <div>Login Successful</div>
      ) : (
        <div className="alert-warning">Invalid Credentials</div>
      )
    );

  return (
    <div>
      <h1>Login Form</h1>
      <form onSubmit={handleSubmit}>
        {loginMessage}
        <label>Email</label>
        <input type="email" name="email" onChange={handleEmailChange} />
        <label>Password</label>
        <input
          type="password"
          name="password"
          onChange={handlePasswordChange}
        />
        <button type="submit">Login</button>
      </form>
    </div>
  );
};

export default Login;
