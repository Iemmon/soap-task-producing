package com.soap.producing.endpoint;

import com.product.ProductCreate;
import com.product.ProductRequest;
import com.product.ProductResponse;
import com.soap.producing.mapper.ResponseMapper;
import com.soap.producing.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@Component
@AllArgsConstructor
public class ProductEndpoint {

    private static final String NAMESPACE_URI = "http://www.product.com/";
    private final ProductService productService;
    private final ResponseMapper responseMapper;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "productRequest")
    @ResponsePayload
    public ProductResponse getProduct(@RequestPayload ProductRequest request) {
        return productService.getProductByName(request.getName());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "productCreate")
    @ResponsePayload
    public ProductResponse createProduct(@RequestPayload ProductCreate productCreate) {
        return responseMapper.fromEntity(productService.createProduct(productCreate));
    }
}
