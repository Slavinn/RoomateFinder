import http from "./http-common";
import axios from "axios";

//this class has the functions that make api calls

class TutorialDataService {
  getAllUsers() {
    return axios.get("http://localhost:8080/api/roommates");
  }
  getRoommateById(id) {
    return axios.get(`http://localhost:8080/api/roommates/${id}`, {});
  }
  createUser(data) {
    return axios.post("http://localhost:8080/api/roommates", data);
  }
  createReview(data) {
    return axios.post("http://localhost:8080/api/reviews", data);
  }

  getRoommateByEmail(email) {
    return axios.get(`http://localhost:8080/api/roommates/${email}`);
  }
}
export default new TutorialDataService();
