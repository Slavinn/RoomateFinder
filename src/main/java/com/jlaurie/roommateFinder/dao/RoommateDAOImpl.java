package com.jlaurie.roommateFinder.dao;

import com.jlaurie.roommateFinder.entity.Roommate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RoommateDAOImpl implements RoommateDAO{

    private EntityManager entityManager;

    @Autowired
    public RoommateDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void createRoommate(Roommate roommate) throws SQLException {
        Session session = entityManager.unwrap(Session.class);
        session.save(roommate);
    }

    @Override
    public Roommate getRoommate(int id) {
        Session session = entityManager.unwrap(Session.class);

        Roommate roommate = session.get(Roommate.class, id);

        return roommate;

    }

    @Override
    public List<Roommate> selectAllRoommates() {
        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("from Roommate",Roommate.class);

        return query.getResultList();

    }

    @Override
    public void updateRoommate(Roommate roommate) throws SQLException {
        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(roommate);
    }

    @Override
    public void deleteRoommate(int id) throws SQLException {
        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("delete from Roommate where id=:roommateId");
        query.setParameter("roommateId", id);

        query.executeUpdate();
    }
}
