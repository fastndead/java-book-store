package orders.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import orders.models.Order;

import java.util.List;

@Repository
@Primary
public class OrderDao {

    private SessionFactory sessionFactory;

    public OrderDao(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public void add(Order entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    public Order getById(int id) {
        return sessionFactory.getCurrentSession().get(Order.class, id);
    }

    public void update(Order entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    public void delete(Order entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    public List<Order> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return (List<Order>) session.createQuery("from " + Order.class.getSimpleName()).list();
    }
}
