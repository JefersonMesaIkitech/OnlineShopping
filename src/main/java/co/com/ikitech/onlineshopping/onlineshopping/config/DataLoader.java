package co.com.ikitech.onlineshopping.onlineshopping.config;

import co.com.ikitech.onlineshopping.onlineshopping.model.Category;
import co.com.ikitech.onlineshopping.onlineshopping.model.Product;
import co.com.ikitech.onlineshopping.onlineshopping.repository.CategoryRepository;
import co.com.ikitech.onlineshopping.onlineshopping.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    @Bean
    CommandLineRunner commandLineRunner(CategoryRepository categoryRepository, ProductRepository productRepository) {
        return args -> {
            Category electronics = new Category("Electronics");
            Category clothing = new Category("Clothing");
            categoryRepository.save(electronics);
            categoryRepository.save(clothing);

            productRepository.save(new Product("Laptop", 1200.00, electronics));
            productRepository.save(new Product("Smartphone", 800.00, electronics));
            productRepository.save(new Product("T-Shirt", 20.00, clothing));
        };
    }
}
