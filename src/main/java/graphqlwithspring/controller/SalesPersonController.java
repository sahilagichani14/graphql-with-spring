package graphqlwithspring.controller;

import graphqlwithspring.data.SalesPerson;
import graphqlwithspring.data.SalesPersonRepo;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class SalesPersonController {
    private final SalesPersonRepo salespersonRepository;

    public SalesPersonController(SalesPersonRepo salespersonRepository) {
        this.salespersonRepository = salespersonRepository;
    }

    @QueryMapping
    public Iterable<SalesPerson> salespeople() {
        return this.salespersonRepository.findAll();
    }

    @QueryMapping
    public SalesPerson salespersonById(@Argument Long id) {
        return this.salespersonRepository.findById(id).orElseThrow();
    }

    @QueryMapping
    public SalesPerson salespersonByEmail(@Argument String email) {
        return this.salespersonRepository.findSalespersonByEmail(email);
    }
}
