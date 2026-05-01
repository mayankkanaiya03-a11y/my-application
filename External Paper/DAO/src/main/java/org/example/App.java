package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

//        cfg.addAnnotatedClasses(Product.class);

        SessionFactory sessionFactory = cfg.buildSessionFactory();
        ProductDAOImpl productDAO = new ProductDAOImpl(sessionFactory);

        Product product = new Product();
        product.setId(1);
        product.setName("Paper FSD");
        product.setPrice(50.23);
        product.setQuantity(10);

        productDAO.addProduct(product);

        Product p1 = productDAO.getProduct(1);
        System.out.println(p1.getName());
    }
}
