package com.soap.producing.mapper;

import com.product.ProductCreate;
import com.soap.producing.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class EntityCreationMapper implements Mapper<ProductEntity, ProductCreate> {

    @Override
    public ProductEntity toEntity(ProductCreate item) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(item.getName());
        productEntity.setPrice(item.getPrice());

        productEntity.setProductionDate(item.getProductionDate().toGregorianCalendar().toZonedDateTime().toLocalDate());
        productEntity.setExpirationDate(item.getExpirationDate().toGregorianCalendar().toZonedDateTime().toLocalDate());

        return productEntity;
    }

    @Override
    public ProductCreate fromEntity(ProductEntity entity) {
        throw new UnsupportedOperationException();
    }
}
