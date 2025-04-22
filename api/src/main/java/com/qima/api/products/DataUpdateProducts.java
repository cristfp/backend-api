package com.qima.api.products;

import jakarta.validation.constraints.NotNull;

public record DataUpdateProducts(@NotNull Long id,
                                 String name,
                                 String description,
                                 String price,
                                 String categoryPath,
                                 String categories,
                                 String available,
                                 String obs) {
}
