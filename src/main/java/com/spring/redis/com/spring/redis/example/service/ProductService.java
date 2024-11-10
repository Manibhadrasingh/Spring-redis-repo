package com.spring.redis.com.spring.redis.example.service;

import com.spring.redis.com.spring.redis.example.model.ProductModel;
import com.spring.redis.com.spring.redis.example.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableCaching
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public ProductModel save(ProductModel productModel) {
        return productRepo.save(productModel);
    }

    public List<ProductModel> findAll(){
        return productRepo.findAll();
    }

    @Cacheable(key = "#id", value = "ProductModel",unless = "#result.price>4000")
    public ProductModel findById(Integer id){
        return productRepo.findById(id);
    }

    @CacheEvict(key="#id", value = "ProductModel")
    public String delete(Integer id){
        return productRepo.deleteProduct(id);
    }
}
