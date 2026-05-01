package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @Column(name = "CUSTOMER_ID")
    int id;

    @Column(name = "CUSTOMER_NAME", nullable = false)
    String name;

    @Column(name = "EMAIL", nullable = false)
    String email;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    BankAccountInfo bankAccount;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
