package com.jlaurie.roommateFinder.service;

import com.jlaurie.roommateFinder.dao.RoommateDAO;
import com.jlaurie.roommateFinder.entity.Roommate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Service
public class RoommateServiceImpl implements RoommateService {

    private RoommateDAO roommateDAO;

    @Autowired
    public RoommateServiceImpl(RoommateDAO roommateDAO) {
        this.roommateDAO = roommateDAO;
    }

    @Override
    @Transactional
    public void createRoommate(Roommate roommate) throws SQLException {
        roommateDAO.createRoommate(roommate);
    }

    @Override
    @Transactional
    public Roommate getRoommate(int id) {
        return roommateDAO.getRoommate(id);
    }

    @Override
    @Transactional
    public List<Roommate> selectAllRoommates() {
        return roommateDAO.selectAllRoommates();
    }

    @Override
    @Transactional
    public void updateRoommate(Roommate roommate) throws SQLException {
        roommateDAO.updateRoommate(roommate);
    }

    @Override
    @Transactional
    public void deleteRoommate(int id) throws SQLException {
        roommateDAO.deleteRoommate(id);
    }
}
