# **Q-6 b**





## ProductDAO.java



package org.example;



public interface ProductDAO {



&#x20;   public Boolean addProduct(Product product);

&#x20;   public Product getProduct(int id);

}







## ProductDAOImpl.java



package org.example;



import org.hibernate.Session;

import org.hibernate.SessionFactory;

import org.hibernate.query.Query;



public class ProductDAOImpl implements ProductDAO {



&#x20;   private SessionFactory sessionFactory;



&#x20;   public ProductDAOImpl(SessionFactory sessionFactory) {

&#x20;       this.sessionFactory = sessionFactory;

&#x20;   }



&#x20;   @Override

&#x20;   public Product getProduct(int id) {



&#x20;       Product p;

&#x20;       try{



&#x20;           Session session = sessionFactory.openSession();

&#x20;           p = session.get(Product.class, id);



&#x20;           return p;



&#x20;       }catch(Exception e){

&#x20;           e.printStackTrace();

&#x20;           return null;

&#x20;       }

&#x20;   }



&#x20;   @Override

&#x20;   public Boolean addProduct(Product product){

&#x20;       try{

&#x20;           Session session = sessionFactory.openSession();



&#x20;           session.beginTransaction();



&#x20;           Product existProduct = getProduct(product.getId());



&#x20;           if(existProduct != null){

&#x20;               return false;

&#x20;           }



&#x20;           session.persist(product);



&#x20;           session.getTransaction().commit();



&#x20;           return true;

&#x20;       }catch(Exception e){

&#x20;           e.printStackTrace();

&#x20;           return false;

&#x20;       }

&#x20;   }





}







## Main.java







package org.example;



import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;



/\*\*

&#x20;\* Hello world!

&#x20;\*

&#x20;\*/

public class Main 

{

&#x20;   public static void main( String\[] args )

&#x20;   {



&#x20;       Configuration cfg = new Configuration();

&#x20;       cfg.addAnnotatedClasses(Product.class);



&#x20;       SessionFactory sessionFactory = cfg.buildSessionFactory();

&#x20;       ProductDAOImpl productDAO = new ProductDAOImpl(sessionFactory);



&#x20;       Product product = new Product();

&#x20;       product.setId(1);

&#x20;       product.setName("Paper FSD");

&#x20;       product.setPrice(50.23);

&#x20;       product.setQuantity(10);



&#x20;       productDAO.addProduct(product);



&#x20;       Product p1 = productDAO.getProduct(1);

&#x20;       System.out.println(p1.getName());

&#x20;   }

}



