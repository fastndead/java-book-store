package orders.controllers;

import orders.models.Order;
import orders.models.Response;
import orders.services.OrderService;
import org.graalvm.compiler.core.common.util.Util;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@RestController
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/orders")
    public void add(@RequestBody Order order) {
        orderService.add(order);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/orders/{id}")
    public Response getById(@PathVariable Integer id) {
       return orderService.getById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/orders")
    public void update(@RequestBody Order order) {
        orderService.update(order);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "orders/{id}")
    public void delete(@PathVariable int id) {
        orderService.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/orders")
    public List<Response> getAll() {
        return orderService.getAll();
    }
}
