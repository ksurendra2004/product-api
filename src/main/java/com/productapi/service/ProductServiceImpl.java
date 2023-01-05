package com.productapi.service;

import com.productapi.exception.NoSuchProductExistsException;
import com.productapi.model.Product;
import com.productapi.model.ProductList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {

    private final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    @Override
    public ProductList sortProductDetails(ProductList productList)  {
        if(productList.getProductList() == null) {
            logger.debug("No Product Details found");
            throw new NoSuchProductExistsException("No Product Details found");
        }else if(productList.getProductList().isEmpty()) {
            logger.debug("No ProductList found");
            throw new NoSuchProductExistsException("No ProductList found");
        } else{
            logger.info("ProductList found");
            return new ProductList(
                    productList
                            .getProductList()
                            .stream()
                            .sorted(Comparator.comparing(Product::getProductId).reversed())
                            .sorted(Comparator.comparing(Product::getLaunchDate).reversed())
                            .collect(Collectors.toList())
            );
        }
    }
}
