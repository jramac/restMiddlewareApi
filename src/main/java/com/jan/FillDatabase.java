package com.jan;

import com.jan.model.category.Category;
import com.jan.model.product.Product;
import com.jan.model.user.User;
import com.jan.service.factory.DataServiceFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.client.RestTemplate;

import java.util.List;

// TODO: 23.06.2024. Pretvori ovo u funkciju koja se pokrece sa serverom,
//  					trenutno ovo sluzi za punit bazu sa podatcima sa WEBAPI-a.
public class FillDatabase {
	public static void main(String[] args) {
		DataServiceFactory factory = DataServiceFactory.getInstance();

		String productApiUrl = "https://dummyjson.com/products";
		String userApiUrl = "https://dummyjson.com/users";
		String categoryApiUrl = "https://dummyjson.com/products/categories";

		List<Product> products= factory.getWebApiProductDataCollector(productApiUrl).getData();
		products.forEach(System.out::println);
		List<User> users = factory.getWebApiUserDataCollector(userApiUrl).getData();
		users.forEach(System.out::println);
		List<Category> categories= factory.getWebApiCategoryDataCollector(categoryApiUrl).getData();
		categories.forEach(System.out::println);

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			 Session session = sessionFactory.openSession()) {

			Transaction transaction = session.beginTransaction();

			products.forEach(session::save);
			users.forEach(session::save);
			categories.forEach(session::save);

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
}

