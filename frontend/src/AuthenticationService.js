import axios from "axios";
import { API_URL } from "./Constants";
import DataStorage from "./DataStorage";

export const USER_NAME_SESSION_ATTRIBUTE_NAME = "authenticatedUser";

class AuthenticationService {
  executeJwtAuthenticationService(email, password) {
    return axios.post(`${API_URL}/authenticate`, {
      email,
      password,
    });
  }

  createJwtAuthToken(token) {
    return "Bearer " + token;
  }

  registerSuccessfulLogin(email, password) {
    sessionStorage.setItem(USER_NAME_SESSION_ATTRIBUTE_NAME, email);
    this.setupAxiosInterceptor(this.createBasicAuthToken(email, password));
  }

  registerSuccessfulLoginForJwt(email, token) {
    sessionStorage.setItem(USER_NAME_SESSION_ATTRIBUTE_NAME, email);
    this.setupAxiosInterceptor(this.createJwtAuthToken(token));
  }

  logout() {
    sessionStorage.removeItem(USER_NAME_SESSION_ATTRIBUTE_NAME);
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem(USER_NAME_SESSION_ATTRIBUTE_NAME);
    return user ? true : false;
  }

  getLoggedInUserName() {
    let user = sessionStorage.getItem(USER_NAME_SESSION_ATTRIBUTE_NAME);
    if (user === null) return "";
    return user;
  }

  setupAxiosInterceptor(authHeaderToken) {
    axios.interceptors.request.use((config) => {
      if (this.isUserLoggedIn()) {
        config.headers["Authorization"] = authHeaderToken;
      }
      return config;
    });
  }
}

export default new AuthenticationService();
