package com.jlaurie.roommateFinder.controller;

import com.jlaurie.roommateFinder.entity.Review;
import com.jlaurie.roommateFinder.entity.Roommate;
import com.jlaurie.roommateFinder.service.RoommateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RoommateRestController {

    private RoommateService roommateService;

    @Autowired
    public RoommateRestController(RoommateService roommateService) {
        this.roommateService = roommateService;
    }

    
    @PostMapping("/signup")
    public String createRoommate(@RequestBody Roommate roommate) throws SQLException {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        roommate.setPassword(encoder.encode(roommate.getPassword()));
        roommateService.createRoommate(roommate);

        return "Created Roommate - " + roommate;
    }


    
    @GetMapping("/roommates")
    public List<Roommate> selectAllRoommates() {
        return roommateService.selectAllRoommates();
    }


    @GetMapping("/roommates/{roommateId}")
    public Roommate getRoommate(@PathVariable int roommateId) {
        Roommate roommate = roommateService.getRoommate(roommateId);

        if (roommate == null) {
            throw new RuntimeException("Roommate ID was not found - " + roommateId);
        }

        return roommate;
    }

    

    @PutMapping("/roommates")
    public String updateRoommate(@RequestBody Roommate roommate) throws SQLException {

        roommateService.updateRoommate(roommate);

        return "Updated roommate - " + roommate;
    }

    @DeleteMapping("/roommates/{roommateId}")
    public String deleteRoommate(@PathVariable int roommateId) throws SQLException {

        roommateService.deleteRoommate(roommateId);

        return "If that roommate exists, he/she was deleted";
    }



}
