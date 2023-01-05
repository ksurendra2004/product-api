package com.productapi.controller;

import com.productapi.model.ProductList;
import com.productapi.service.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    IProductService iProductService;
    private final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @PostMapping("/sortProducts")
    public ProductList sortProducts(@RequestBody ProductList productList) {
        logger.debug("In sortProducts method");
        return iProductService.sortProductDetails(productList);
    }
}
