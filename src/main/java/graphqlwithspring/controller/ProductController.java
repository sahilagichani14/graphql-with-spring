package graphqlwithspring.controller;

import graphqlwithspring.data.Product;
import graphqlwithspring.data.ProductRepo;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {
    private final ProductRepo productRepository;

    public ProductController(ProductRepo productRepository) {
        this.productRepository = productRepository;
    }

    @QueryMapping
    public Iterable<Product> products() {
        return this.productRepository.findAll();
    }

    @QueryMapping
    public Product productById(@Argument String id) {
        return this.productRepository.findById(id).orElseThrow();
    }
}
