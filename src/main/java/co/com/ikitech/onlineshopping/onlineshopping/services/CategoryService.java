package co.com.ikitech.onlineshopping.onlineshopping.services;

import co.com.ikitech.onlineshopping.onlineshopping.dto.CategoryDTO;
import co.com.ikitech.onlineshopping.onlineshopping.model.Category;
import co.com.ikitech.onlineshopping.onlineshopping.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor  // Automatically generates a constructor with required dependencies
public class CategoryService {

    private final CategoryRepository categoryRepository;

    // Retrieves all categories and converts them to CategoryDTOs
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll()  // Fetches all categories from DB
                .stream()  // Converts list to a stream for processing
                .map(this::convertToDTO)  // Converts each category to DTO
                .collect(Collectors.toList());  // Collects the results into a list
    }

    // Retrieves a category by its ID and converts it to a DTO
    public Optional<CategoryDTO> getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(this::convertToDTO);
    }

    // Saves a new category and returns the saved category as DTO
    public CategoryDTO createCategory(Category category) {
        return convertToDTO(categoryRepository.save(category));
    }

    // Updates an existing category by ID and returns the updated category as DTO
    public CategoryDTO updateCategory(Long id, Category category) {
        category.setId(id);
        return convertToDTO(categoryRepository.save(category));
    }

    // Deletes a category by its ID
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    // Helper method to convert Category entity to CategoryDTO
    private CategoryDTO convertToDTO(Category category) {
        return new CategoryDTO(
                category.getId(),
                category.getName()
        );
    }
}