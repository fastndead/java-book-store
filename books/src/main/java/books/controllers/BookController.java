package books.controllers;

import books.models.Book;
import books.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/books")
    public void addPost(@RequestBody Book book){
        bookService.add(book);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/books/{id}")
    public Book getPostById(@PathVariable Integer id){
        return (Book) bookService.getById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/books")
    public void
    updatePost(@RequestBody Book post){
        bookService.update(post);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "books/{id}")
    public void deletePost(@PathVariable int id){
        bookService.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/books")
    public List<Book> getAll(){
        return bookService.getAll();
    }
}
