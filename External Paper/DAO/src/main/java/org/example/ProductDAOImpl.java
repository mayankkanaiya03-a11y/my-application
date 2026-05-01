package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class ProductDAOImpl implements ProductDAO {

    private SessionFactory sessionFactory;

    public ProductDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Product getProduct(int id) {


        try{

            Session session = sessionFactory.openSession();
            Product p = session.get(Product.class, id);

            return p;

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean addProduct(Product product){
        try{
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            tx.begin();

            Product existProduct = getProduct(product.getId());

            if(existProduct != null){
                return false;
            }

            session.persist(product);

            tx.commit();

            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }


}
