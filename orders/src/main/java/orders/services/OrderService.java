package orders.services;

import orders.models.Response;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;

import orders.DAO.OrderDao;
import orders.models.Order;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Primary
public class OrderService {

    private OrderDao orderDao;

    public OrderService(OrderDao orderDao){
        this.orderDao = orderDao;
    }

    @Transactional
    public void add(Order entity) {
        orderDao.add(entity);
    }

    @Transactional
    public Response getById(int id) {
        Order order = (Order) orderDao.getById(id);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> responseEntityForBooks = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/todos/1 ", Object.class);
        ResponseEntity<Object> responseEntityForUsers = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/todos/2", Object.class);
        Object book = responseEntityForBooks.getBody();
        Object user = responseEntityForUsers.getBody();
        return new Response(order.getId(), book, user);
    }

    @Transactional
    public void update(Order entity) {
        orderDao.update(entity);
    }

    @Transactional
    public void deleteById(int id) {
        Order res = (Order) orderDao.getById(id);
        orderDao.delete(res);
    }

    @Transactional
    public List<Response> getAll() {
        List<Order> orders = orderDao.getAll();
        List<Response> responses = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        for (Order order:orders) {
            ResponseEntity<Object> responseEntityForBooks = restTemplate.getForEntity("http://localhost:8888/books/" + order.getBookId(), Object.class);
            ResponseEntity<Object> responseEntityForUsers = restTemplate.getForEntity("http://localhost:8889/users/" + order.getUserId(), Object.class);
            Object book = responseEntityForBooks.getBody();
            Object user = responseEntityForUsers.getBody();
            responses.add(new Response(order.getId(), book, user));
        }
        return responses;
    }

}
