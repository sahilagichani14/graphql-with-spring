package graphqlwithspring.controller;

import graphqlwithspring.data.Order;
import graphqlwithspring.data.OrderRepo;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {
    private final OrderRepo orderRepository;

    public OrderController(OrderRepo orderRepository) {
        this.orderRepository = orderRepository;
    }

    @QueryMapping
    public Iterable<Order> orders() {
        return this.orderRepository.findAll();
    }

    @QueryMapping
    public Order orderById(@Argument String id) {
        return this.orderRepository.findById(id).orElseThrow();
    }
}
