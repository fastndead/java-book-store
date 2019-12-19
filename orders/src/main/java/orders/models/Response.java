package orders.models;

import javax.persistence.Entity;

public class Response {
    private int id;
    private Object book;
    private Object user;

    public Response(int id, Object book, Object user) {
        this.id = id;
        this.book = book;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getBook() {
        return book;
    }

    public void setBook(Object book) {
        this.book = book;
    }

    public Object getUser() {
        return user;
    }

    public void setUser(Object user) {
        this.user = user;
    }
}
