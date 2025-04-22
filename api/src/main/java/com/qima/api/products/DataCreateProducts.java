package com.qima.api.products;

import com.qima.api.categories.DataCategories;

public record DataCreateProducts(
        Long id,
        String name,
        String description,
        String price,
        String categoryPath,
        String categories,
        String available,
        String obs) {
}
