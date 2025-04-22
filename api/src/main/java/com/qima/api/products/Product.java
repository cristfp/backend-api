package com.qima.api.products;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "products")
@Table(name = "Product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String price;
    private String categoryPath;
    private String categories;
    private String available;
    private String obs;

    public Product(DataCreateProducts data) {
        this.name = data.name();
        this.description = data.description();
        this.price = data.price();
        this.categoryPath = data.categoryPath();
        this.categories = data.categories();
        this.available = data.available();
        this.obs = data.obs();
    }

    public void updateData(DataUpdateProducts data) {

        if(data.name()!=null){
            this.name = data.name();
        }
        if(data.description()!=null){
            this.description = data.description();
        }
        if(data.price()!=null){
            this.price = data.price();
        }
        if(data.categoryPath()!=null){
            this.categoryPath = data.categoryPath();
        }
        if(data.categories()!=null){
            this.categories = data.categories();
        }
        if(data.available()!=null){
            this.available = data.available();
        }
        if(data.obs()!=null){
            this.obs = data.obs();
        }
    }
}
