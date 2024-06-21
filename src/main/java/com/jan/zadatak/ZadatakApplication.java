package com.jan.zadatak;

import com.jan.model.category.Category;
import com.jan.model.product.Product;
import com.jan.model.product.ProductResponse;
import com.jan.model.user.User;
import com.jan.model.user.UserResponse;
import com.jan.service.WebApiDataCollectorCategories;
import com.jan.service.WebApiDataCollectorProducts;
import com.jan.service.WebApiDataCollectorUsers;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class ZadatakApplication {
	public static void main(String[] args) throws IOException, InterruptedException {

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


		//SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        //Session session = sessionFactory.openSession();
		//Transaction transaction = session.beginTransaction();
		//try {
		//	List<Product> products = fetchProductsFromApi(API_URL);
			// Print out the products or do something with them

		//	products.forEach(System.out::println);
		//} catch (IOException | InterruptedException e) {
		//	e.printStackTrace();
		//}
		//transaction.commit();

		//sessionFactory.close();
	}
}

