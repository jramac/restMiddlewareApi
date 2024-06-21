package com.jan.zadatak;

import com.jan.model.product.Dimensions;
import com.jan.model.product.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZadatakApplication {

	public static void main(String[] args){

		Product prod = new Product();
		prod.setBrand("smokey");
		prod.setId(2);
		Dimensions dimensions = new Dimensions();
		dimensions.setWidth(5);
		dimensions.setHeight(1);
		dimensions.setDepth(5);
		prod.setDimensions(dimensions);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(prod);

		transaction.commit();

        sessionFactory.close();
	}
}
