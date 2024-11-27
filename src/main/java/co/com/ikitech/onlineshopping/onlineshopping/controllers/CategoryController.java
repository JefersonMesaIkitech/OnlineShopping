package co.com.ikitech.onlineshopping.onlineshopping.controllers;

import co.com.ikitech.onlineshopping.onlineshopping.dto.CategoryDTO;
import co.com.ikitech.onlineshopping.onlineshopping.model.Category;
import co.com.ikitech.onlineshopping.onlineshopping.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This controller provides the RESTful API for managing categories in the online shopping platform.
 * It exposes endpoints for creating, reading, updating, and deleting categories.
 * All responses are wrapped in appropriate HTTP response entities.
 * The controller relies on the CategoryService for business logic.
 */

@RestController
@RequestMapping("/api/categories") // Base URL for all category-related operations
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;


    /**
     * Retrieves all categories.
     *
     * @return a list of CategoryDTO objects representing all categories.
     */

    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

    /**
     * Retrieves a category by its ID.
     *
     * @param id the ID of the category to fetch.
     * @return a ResponseEntity containing the category DTO or a 404 Not Found if the category does not exist.
     */


    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Creates a new category.
     *
     * @param category the category object to create.
     * @return a ResponseEntity containing the created category DTO.
     */



    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    /**
     * Updates an existing category by ID.
     *
     * @param id the ID of the category to update.
     * @param categoryDetails the updated category details.
     * @return a ResponseEntity containing the updated category DTO, or a 404 Not Found if the category does not exist.
     */

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
        try {
            return ResponseEntity.ok(categoryService.updateCategory(id, categoryDetails));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Deletes a category by its ID.
     *
     * @param id the ID of the category to delete.
     * @return a ResponseEntity with status 204 No Content after successful deletion.
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
