package com.includestudio.tokenwall.repository;

import com.includestudio.tokenwall.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Since: 5/13/12
 */
@Repository("userRepository")
@Transactional
public class UserRepositoryImpl implements UserRepository {

    private SessionFactory sessionFactory;

    @Override
    public User findByUsername(String username) {
        return (User) sessionFactory.getCurrentSession().get(User.class, username);
    }

    @Override
    public void store(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
