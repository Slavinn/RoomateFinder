package com.jlaurie.roommateFinder.service;

import com.jlaurie.roommateFinder.entity.Roommate;

import java.sql.SQLException;
import java.util.List;

public interface RoommateService {

    public void createRoommate(Roommate roommate) throws SQLException;

    public Roommate getRoommate(int id);

    public List<Roommate> selectAllRoommates();

    public void updateRoommate(Roommate roommate) throws SQLException;

    public void deleteRoommate(int id) throws SQLException;

    public Roommate findByEmail(String email);
}
