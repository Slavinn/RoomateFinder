package com.jlaurie.roommateFinder.dao;

import com.jlaurie.roommateFinder.entity.Roommate;

import java.sql.SQLException;
import java.util.List;

public interface RoommateDAO {

    // create or insert roommate
    public void createRoommate(Roommate roommate) throws SQLException;

    // select a roommate
    public Roommate getRoommate(int id);

    // select all roommates
    public List<Roommate> selectAllRoommates();

    // update roommate
    public void updateRoommate(Roommate roommate) throws SQLException;

    // delete roommate
    public void deleteRoommate(int id) throws SQLException;
}
