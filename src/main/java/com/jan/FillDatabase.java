package com.jan;

import com.jan.model.category.Category;
import com.jan.model.product.Product;
import com.jan.model.user.User;
import com.jan.service.WebApiDataCollectorCategories;
import com.jan.service.WebApiDataCollectorProducts;
import com.jan.service.WebApiDataCollectorUsers;
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
@SpringBootApplication
@EntityScan(basePackages = {"com.jan.model.user", "com.jan.model.product", "com.jan.model.category"})
public class FillDatabase {
	public static void main(String[] args) {

		RestTemplate restTemplate = new RestTemplate();
		String apiUrl = "https://dummyjson.com/products";
		String apiUrl2 = "https://dummyjson.com/users";
		String apiUrl3 = "https://dummyjson.com/products/categories";

		WebApiDataCollectorProducts webApiDataCollector = new WebApiDataCollectorProducts(restTemplate,apiUrl);
		List<Product> products = webApiDataCollector.getData();
		products.forEach(System.out::println);

		WebApiDataCollectorUsers webApiDataCollector2 = new WebApiDataCollectorUsers(restTemplate,apiUrl2);
		List<User> users = webApiDataCollector2.getData();
		users.forEach(System.out::println);

		WebApiDataCollectorCategories webApiDataCollector3 = new WebApiDataCollectorCategories(restTemplate,apiUrl3);
		List<Category> categories = webApiDataCollector3.getData();
		categories.forEach(System.out::println);

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			 Session session = sessionFactory.openSession()) {

			// Transaction for batch save
			Transaction transaction = session.beginTransaction();

			// Save each product

			products.forEach(session::save);
			users.forEach(session::save);
			categories.forEach(session::save);


			// Commit the transaction
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
}

