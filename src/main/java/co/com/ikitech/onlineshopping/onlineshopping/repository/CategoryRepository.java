package co.com.ikitech.onlineshopping.onlineshopping.repository;

import co.com.ikitech.onlineshopping.onlineshopping.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}