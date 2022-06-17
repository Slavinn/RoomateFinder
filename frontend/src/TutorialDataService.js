import axios from "axios";
import AuthenticationService from "./AuthenticationService";

//this class has the functions that make api calls

class TutorialDataService {
  getAllUsers() {
    return axios.get("http://localhost:8080/api/roommates");
  }
  getRoommateById(id) {
    return axios.get(`http://localhost:8080/api/roommates/${id}`);
  }
  createUser(data) {
    return axios.post("http://localhost:8080/api/signup", data);
  }
  createReview(data) { 
    return axios.post("http://localhost:8080/api/reviews", data);
  }

  getRoommateByEmail(email) {
    return axios.get(`http://localhost:8080/login/${email}`);
  }
}
export default new TutorialDataService();
