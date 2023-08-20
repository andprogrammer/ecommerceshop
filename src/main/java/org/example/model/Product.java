package org.example.model;

import java.util.Objects;

public class Product {
    Long id;
    String category;

    public Product(Long id, String category) {
        this.id = id;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category);
    }

    public Long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }
}
