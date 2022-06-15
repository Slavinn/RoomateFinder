import http from "./http-common";
import axios from "axios";

//this class has the functions that make api calls

class TutorialDataService {
  getAllUsers() {
    return axios.get("http://localhost:8080/api/roommates");
  }
  getRoommateById(id) {
    return axios.get(`http://localhost:8080/api/roommates/${id}`,{});
  }
  createUser(data) {
    return axios.post('http://localhost:8080/api/roommates', data);
  }
  updateUser(data) {
    return http.put(`/roommates`, data);
  }
  deleteUser(id) {
    return http.delete(`/${id}`);
  }
  getAllReviews(){
    return http.get('/reviews')
  }
  getReviewById(id) {
    return http.get(`/reviews/${id}`);
  }
  createReview(data) {
    return axios.post('http://localhost:8080/api/reviews', data);
  }
  updateReview(data) {
    return http.put(`/reviews`, data);
  }
  deleteReview(id) {
    return http.delete(`/reviews/${id}`);
  }
}
export default new TutorialDataService();