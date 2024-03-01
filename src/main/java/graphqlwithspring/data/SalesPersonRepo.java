package graphqlwithspring.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesPersonRepo extends JpaRepository<SalesPerson, Long> {
    SalesPerson findSalespersonByEmail(String email);
}
