package co.com.ikitech.onlineshopping.onlineshopping.services;


import co.com.ikitech.onlineshopping.onlineshopping.dto.ProductDTO;
import co.com.ikitech.onlineshopping.onlineshopping.model.Product;
import co.com.ikitech.onlineshopping.onlineshopping.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    // Retrieves all products and maps them to ProductDTOs
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Retrieves a product by its ID and maps it to ProductDTO
    public Optional<ProductDTO> getProductById(Long id) {
        return productRepository.findById(id)
                .map(this::convertToDTO);
    }

    // Creates a new product and returns it as a ProductDTO
    public ProductDTO createProduct(Product product) {
        return convertToDTO(productRepository.save(product));
    }

    // Updates an existing product and returns the updated product as DTO
    public ProductDTO updateProduct(Long id, Product product) {
        return convertToDTO(productRepository.save(product));
    }

    // Deletes a product by its ID
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }



    // Helper method to convert Product entity to ProductDTO
    private ProductDTO convertToDTO(Product product) {
        return new ProductDTO( // Maps the fields from Product to ProductDTO
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                product.getCategory() != null ? product.getCategory().getName() : null
        );
    }
}
