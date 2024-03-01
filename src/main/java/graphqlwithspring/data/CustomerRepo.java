package graphqlwithspring.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Customer findCustomerByEmail(String email);
}
