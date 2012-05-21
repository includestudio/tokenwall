package com.includestudio.tokenwall.infrastructure.persistence.hibernate;

import com.includestudio.tokenwall.domain.model.user.User;
import com.includestudio.tokenwall.domain.model.user.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Since: 5/13/12
 */
@Repository("userRepository")
@Transactional
public class UserRepositoryImpl extends HibernateRepository implements UserRepository {

    @Override
    public User findByUsername(String username) {
        return (User) currentSession().get(User.class, username);
    }

    @Override
    public void store(User user) {
        currentSession().saveOrUpdate(user);
    }

}
