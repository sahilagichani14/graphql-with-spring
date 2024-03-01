package graphqlwithspring.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="ORDERS")
@Getter
@Setter
public class Order {
    @Id
    @Column(name="ORDER_ID")
    private String id;

    @ManyToOne
    @JoinColumn(name="CUSTOMER_ID", nullable = false, updatable = false)
    private Customer customer; // This allows to get customer info with order itself

    @ManyToOne
    @JoinColumn(name="SALESPERSON_ID", nullable = false, updatable = false)
    private SalesPerson salesperson;

    // this is not in this table and is another separate table
    @OneToMany(mappedBy = "order")
    private List<OrderLine> orderLines;
}
