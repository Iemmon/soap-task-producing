package com.soap.producing.service;

import com.product.ProductCreate;
import com.product.ProductResponse;
import com.soap.producing.entity.ProductEntity;

public interface ProductService {
    ProductResponse getProductByName(String name);

    ProductEntity createProduct(ProductCreate product);
}
