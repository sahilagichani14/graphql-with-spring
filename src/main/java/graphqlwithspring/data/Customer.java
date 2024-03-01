package graphqlwithspring.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CUSTOMERS")
@Getter
@Setter
public class Customer {
        @Id
        @Column(name = "CUSTOMER_ID")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(name = "FIRST_NAME")
        private String firstName;

        @Column(name = "LAST_NAME")
        private String lastName;

        @Column(name = "EMAIL")
        private String email;

        @Column(name = "PHONE")
        private String phoneNumber;

        @Column(name = "ADDRESS")
        private String address;

        @Column(name = "CITY")
        private String city;

        @Column(name = "STATE")
        private String state;

        @Column(name = "ZIPCODE")
        private String zipCode;
}
