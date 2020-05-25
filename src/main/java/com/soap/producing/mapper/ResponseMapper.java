package com.soap.producing.mapper;

import com.product.ProductResponse;
import com.soap.producing.entity.ProductEntity;
import org.springframework.stereotype.Component;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

@Component
public class ResponseMapper implements Mapper<ProductEntity, ProductResponse> {

    @Override
    public ProductEntity toEntity(ProductResponse item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ProductResponse fromEntity(ProductEntity entity) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setName(entity.getName());
        productResponse.setPrice(entity.getPrice());

        try {
            XMLGregorianCalendar xcalProduction = DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(entity.getProductionDate().toString());
            XMLGregorianCalendar xcalExpiration = DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(entity.getExpirationDate().toString());
            productResponse.setProductionDate(xcalProduction);
            productResponse.setExpirationDate(xcalExpiration);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        return productResponse;
    }
}
