package com.puding.test.service;

import com.puding.test.dto.request.AddProductReq;
import com.puding.test.dto.response.AddProductRes;
import com.puding.test.dto.response.ErrorRes;
import com.puding.test.entity.ProductEntity;
import com.puding.test.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity<Object> addProduct(AddProductReq addProductReq) {
        try{
            ProductEntity product = new ProductEntity();
            product.setName(addProductReq.getName());
            product.setType(addProductReq.getType());
            product.setPrice(addProductReq.getPrice());
            product.setQuantity(addProductReq.getQuantity());
            product.setProfitPercentage(addProductReq.getProfitPercentage());
            product.setTaxPercentage(addProductReq.getTaxPercentage());
            product.setShippingCost(addProductReq.getShippingCost());
            product.setCreatedAt(LocalDateTime.now());
            product.setUpdatedAt(null);
            product.setDeletedAt(null);

            ProductEntity savedProduct = productRepository.save(product);

            AddProductRes addProductRes = new AddProductRes();
            addProductRes.setId(savedProduct.getId());
            addProductRes.setName(savedProduct.getName());
            addProductRes.setType(savedProduct.getType());
            addProductRes.setPrice(savedProduct.getPrice());
            addProductRes.setQuantity(savedProduct.getQuantity());
            addProductRes.setProfitPercentage(savedProduct.getProfitPercentage());
            addProductRes.setTaxPercentage(savedProduct.getTaxPercentage());
            addProductRes.setShippingCost(savedProduct.getShippingCost());
            addProductRes.setCreatedAt(savedProduct.getCreatedAt().toString());
            addProductRes.setUpdatedAt(savedProduct.getUpdatedAt() != null ? savedProduct.getUpdatedAt().toString() : null);

            return new ResponseEntity<>(addProductRes, HttpStatus.CREATED);
        }catch (Exception e){
            ErrorRes errorRes = new ErrorRes();
            errorRes.setMessage(e.getMessage());
            return new ResponseEntity<>(errorRes, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
