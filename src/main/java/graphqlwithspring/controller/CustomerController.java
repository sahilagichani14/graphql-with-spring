package graphqlwithspring.controller;

import graphqlwithspring.CustomerInput;
import graphqlwithspring.data.Customer;
import graphqlwithspring.data.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller //no RestController as its GraphQL
public class CustomerController {
    private final CustomerRepo customerRepo; //no need to autowire as there is only 1 constructor & spring will automatically put it

    public CustomerController(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @QueryMapping
    public Iterable<Customer> customers() {
        return this.customerRepo.findAll();
    }

    @QueryMapping
    public Customer customerById(@Argument Long id) {
        return this.customerRepo.findById(id).orElseThrow();
    }

    @QueryMapping
    public Customer customerByEmail(@Argument String email) {
        return this.customerRepo.findCustomerByEmail(email);
    }

    @MutationMapping
    public Customer addCustomer(@Argument(name = "input") CustomerInput customerInput) {
        return this.customerRepo.save(customerInput.getCustomerEntity());
    }

}
