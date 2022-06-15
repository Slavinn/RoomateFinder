package com.jlaurie.roommateFinder.controller;

import com.jlaurie.roommateFinder.entity.Roommate;
import com.jlaurie.roommateFinder.service.RoommateService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/roommates")
    public String createRoommate(@RequestBody Roommate roommate) throws SQLException {
        roommateService.createRoommate(roommate);

        return "Created Roommate - " + roommate;
    }

    @GetMapping("/roommates/{roommateId}")
    public Roommate getRoommate(@PathVariable String roommateId) {
        Roommate roommate = roommateService.getRoommate(Integer.parseInt(roommateId));

        if (roommate == null) {
            throw new RuntimeException("Roommate ID was not found - " + roommateId);
        }

        return roommate;
    }

    @GetMapping("/roommates")
    public List<Roommate> selectAllRoommates() {
        return roommateService.selectAllRoommates();
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
}
