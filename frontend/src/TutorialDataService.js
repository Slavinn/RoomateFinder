import http from "./http-common";
import axios from "axios";

//this class has the functions that make api calls

class TutorialDataService {
  getAllUsers() {
    return http.get("/roommates");
  }
  getRoommateById(id) {
    return http.get(`/roommates/${id}`);
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
    return axios.post('/review', data);
  }
  updateReview(data) {
    return http.put(`/reviews`, data);
  }
  deleteReview(id) {
    return http.delete(`/reviews/${id}`);
  }
}
export default new TutorialDataService();