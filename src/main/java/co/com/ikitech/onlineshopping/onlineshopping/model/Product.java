package co.com.ikitech.onlineshopping.onlineshopping.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The Category model represents the items that can be placed in the database
 * id
 * name
 * description
 * price
 * stock
 * weight
 * brand
 * category
 */

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String description;
    @Column(nullable = false)
    private double price;
    private int stock;
    private float weight;
    private String brand;

    @ManyToOne  // Defines a many-to-one relationship with Category
    @JoinColumn(name = "category_id", nullable = false)  // Specifies the foreign key and ensures it's not null
    private Category category;


    @Column(name = "image_Path")
    private String imagePath;

    public Product(String name, double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }


}
