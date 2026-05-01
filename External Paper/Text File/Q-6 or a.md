# **Q-6 or a**







## Customer.java









package org.example;



import jakarta.persistence.\*;



@Entity

@Table(name = "CUSTOMER")

public class Customer {



&#x20;   @Id

&#x20;   @Column(name = "CUSTOMER\_ID")

&#x20;   int id;



&#x20;   @Column(name = "CUSTOMER\_NAME", nullable = false)

&#x20;   String name;



&#x20;   @Column(name = "EMAIL", nullable = false)

&#x20;   String email;



&#x20;   @ManyToOne(cascade = CascadeType.ALL)

&#x20;   @JoinColumn

&#x20;   BankAccountInfo bankAccount;





&#x20;   public int getId() {

&#x20;       return id;

&#x20;   }



&#x20;   public void setId(int id) {

&#x20;       this.id = id;

&#x20;   }



&#x20;   public String getName() {

&#x20;       return name;

&#x20;   }



&#x20;   public void setName(String name) {

&#x20;       this.name = name;

&#x20;   }



&#x20;   public String getEmail() {

&#x20;       return email;

&#x20;   }



&#x20;   public void setEmail(String email) {

&#x20;       this.email = email;

&#x20;   }

}











## BankAccountInfo.java









package org.example;



import jakarta.persistence.\*;



import java.util.List;



@Entity

@Table(name = "BANK\_ACCOUNT\_INFO")

public class BankAccountInfo {



&#x20;   @Id

&#x20;   @GeneratedValue(strategy = GenerationType.IDENTITY)

&#x20;   @Column(name = "ACCOUNT\_ID")

&#x20;   int id;



&#x20;   @Column(name = "ACCOUNT\_NUMBER", nullable = false)

&#x20;   String accountNumber;



&#x20;   @Column(name = "IFSC\_CODE", nullable = false)

&#x20;   String ifscCode;



&#x20;   @OneToMany(cascade = CascadeType.ALL, mappedBy = "bankAccount")

&#x20;   List<Customer> customers;





&#x20;   public int getId() {

&#x20;       return id;

&#x20;   }



&#x20;   public void setId(int id) {

&#x20;       this.id = id;

&#x20;   }



&#x20;   public String getAccountNumber() {

&#x20;       return accountNumber;

&#x20;   }



&#x20;   public void setAccountNumber(String accountNumber) {

&#x20;       this.accountNumber = accountNumber;

&#x20;   }



&#x20;   public String getIfscCode() {

&#x20;       return ifscCode;

&#x20;   }



&#x20;   public void setIfscCode(String ifscCode) {

&#x20;       this.ifscCode = ifscCode;

&#x20;   }

}



