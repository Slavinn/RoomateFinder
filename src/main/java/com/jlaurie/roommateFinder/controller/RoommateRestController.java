package com.jlaurie.roommateFinder.controller;

import com.jlaurie.roommateFinder.entity.Roommate;
import com.jlaurie.roommateFinder.service.RoommateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
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

    @DeleteMapping("/roommates/{id}")
    public String deleteRoommate(@PathVariable int id) throws SQLException {

        roommateService.deleteRoommate(id);

        return "If that roommate exists, he/she was deleted";
    }


    @GetMapping("/roommates/{email}")
    public Roommate getRoommateEmail(@PathVariable String email) {
        Roommate roommate = roommateService.findByEmail(email);

        if (roommate == null) {
            throw new RuntimeException("Roommate Email was not found - " + email);
        }

        return roommate;
    }
}
