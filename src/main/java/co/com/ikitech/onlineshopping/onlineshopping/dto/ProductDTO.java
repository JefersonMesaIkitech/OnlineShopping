package co.com.ikitech.onlineshopping.onlineshopping.dto;


import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * ProductDTO is a Data Transfer Object used to carry product data between different layers of the application.
 * It contains product details like ID, name, description, price, stock, and category name.
 * The Lombok annotations @Data and @AllArgsConstructor reduce boilerplate code for getters, setters, toString, and constructors.
 */

@Data
@AllArgsConstructor
public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private double price;
    private int stock;
    private String categoryName;

}
