package co.com.ikitech.onlineshopping.onlineshopping.controllers;


import co.com.ikitech.onlineshopping.onlineshopping.dto.ProductDTO;
import co.com.ikitech.onlineshopping.onlineshopping.model.Product;
import co.com.ikitech.onlineshopping.onlineshopping.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Controller for managing products in the online shopping system.
 * Exposes CRUD operations for product entities.
 */

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    /**
     * Endpoint to get all products.
     *
     * @return List of ProductDTO objects
     */

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * Endpoint to get a specific product by its ID.
     *
     * @param id The product ID
     * @return ResponseEntity with product or 404 if not found
     */


    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Endpoint to create a new product.
     *
     * @param product The product to create
     * @return ResponseEntity with the created product
     */

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }

    /**
     * Endpoint to update an existing product.
     *
     * @param id The product ID to update
     * @param productDetails The new product details
     * @return ResponseEntity with updated product or 404 if not found
     */

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        try {
            return ResponseEntity.ok(productService.updateProduct(id, productDetails));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Endpoint to delete a product by its ID.
     *
     * @param id The product ID to delete
     * @return ResponseEntity with 204 No Content on successful deletion
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}
