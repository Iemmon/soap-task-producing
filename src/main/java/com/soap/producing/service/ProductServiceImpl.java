package com.soap.producing.service;

import com.product.ProductCreate;
import com.product.ProductResponse;
import com.soap.producing.entity.ProductEntity;
import com.soap.producing.exception.ResourceNotFoundException;
import com.soap.producing.mapper.EntityCreationMapper;
import com.soap.producing.mapper.ResponseMapper;
import com.soap.producing.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final EntityCreationMapper entityCreationMapper;
    private final ResponseMapper responseMapper;

    @Override
    public ProductResponse getProductByName(String name) {
        return responseMapper.fromEntity(productRepository.findOneByName(name)
                .orElseThrow(ResourceNotFoundException::new));
    }
    @Override
    public ProductEntity createProduct(ProductCreate product) {
        return productRepository.save(entityCreationMapper.toEntity(product));
    }
}
