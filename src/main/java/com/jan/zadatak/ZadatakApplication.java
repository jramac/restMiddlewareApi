package com.jan.zadatak;

import com.jan.model.category.Category;
import com.jan.model.product.Product;
import com.jan.model.product.ProductResponse;
import com.jan.model.user.User;
import com.jan.model.user.UserResponse;
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

import java.io.IOException;
import java.util.List;

@SpringBootApplication
@EntityScan(basePackages = {"com.jan.model.user", "com.jan.model.product", "com.jan.model.category"})
public class ZadatakApplication {
	public static void main(String[] args) {

		RestTemplate restTemplate = new RestTemplate();
		String apiUrl = "https://dummyjson.com/products";
		String apiUrl2 = "https://dummyjson.com/users";
		String apiUrl3 = "https://dummyjson.com/products/categories";

		WebApiDataCollectorProducts webApiDataCollector = new WebApiDataCollectorProducts(restTemplate,apiUrl);

		ProductResponse productResponse = webApiDataCollector.getData();
		List<Product> products = productResponse.getProducts();
		products.forEach(System.out::println);

		WebApiDataCollectorUsers webApiDataCollector2 = new WebApiDataCollectorUsers(restTemplate,apiUrl2);

		UserResponse userResponse = webApiDataCollector2.getData();
		List<User> users = userResponse.getUsers();
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
			users.forEach(session::save);

			// Commit the transaction
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
}

