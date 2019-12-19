package users.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import users.models.User;

import java.util.List;

@Repository
@Primary
public class UserDao {

    private SessionFactory sessionFactory;

    public UserDao(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public void add(User entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    public User getById(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    public void update(User entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    public void delete(User entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return (List<User>) session.createQuery("from " + User.class.getSimpleName()).list();
    }
}
