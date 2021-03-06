import { Navigate } from "react-router-dom";
import AuthenticationService from "./AuthenticationService";

const AuthenticatedRoute = (props) => {
  if (AuthenticationService.isUserLoggedIn()) {
    return { ...props.children };
  } else {
    return <Navigate to="/login" />;
  }
};

export default AuthenticatedRoute;
