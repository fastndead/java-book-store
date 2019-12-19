package books.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import books.DAO.BookDao;
import books.models.Book;

import java.util.List;

@Service
@Primary
public class BookService {

    private BookDao bookDao;

    public BookService(BookDao bookDao){
        this.bookDao = bookDao;
    }

    @Transactional
    public void add(Book entity) {
        bookDao.add(entity);
    }

    @Transactional
    public Book getById(int id) {
        return (Book) bookDao.getById(id);
    }

    @Transactional
    public void update(Book entity) {
        bookDao.update(entity);
    }

    @Transactional
    public void deleteById(int id) {
        Book res = (Book) bookDao.getById(id);
        bookDao.delete(res);
    }

    @Transactional
    public List<Book> getAll() {
        return bookDao.getAll();
    }

}
