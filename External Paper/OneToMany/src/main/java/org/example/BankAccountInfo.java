package org.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "BANK_ACCOUNT_INFO")
public class BankAccountInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_ID")
    int id;

    @Column(name = "ACCOUNT_NUMBER", nullable = false)
    String accountNumber;

    @Column(name = "IFSC_CODE", nullable = false)
    String ifscCode;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bankAccount")
    List<Customer> customers;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }
}
