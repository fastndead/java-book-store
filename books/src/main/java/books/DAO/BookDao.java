package books.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import books.models.Book;

import java.util.List;

@Repository
@Primary
public class BookDao {

    private SessionFactory sessionFactory;

    public BookDao(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public void add(Book entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    public Book getById(int id) {
        return sessionFactory.getCurrentSession().get(Book.class, id);
    }

    public void update(Book entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    public void delete(Book entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    public List<Book> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return (List<Book>) session.createQuery("from " + Book.class.getSimpleName()).list();
    }
}
