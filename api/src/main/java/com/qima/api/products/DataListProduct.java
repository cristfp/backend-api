package com.qima.api.products;

public record DataListProduct(Long id,
                              String name,
                              String description,
                              String price,
                              String categoryPath,
                              String categories,
                              String available,
                              String obs) {



    public DataListProduct(Product product) {
        this(product.getId(),product.getName(), product.getDescription(), product.getPrice(), product.getCategoryPath(), product.getCategories(), product.getAvailable(), product.getObs());
    }


}
