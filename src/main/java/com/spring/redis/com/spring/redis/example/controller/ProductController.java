package com.spring.redis.com.spring.redis.example.controller;

import com.spring.redis.com.spring.redis.example.model.ProductModel;
import com.spring.redis.com.spring.redis.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public ProductModel save(@RequestBody ProductModel productModel){
        return productService.save(productModel);
    }

    @GetMapping("/findAll")
    public List<ProductModel> findAll(){
        return productService.findAll();
    }

    @GetMapping("/findById/{id}")
    public ProductModel findById(@PathVariable("id") Integer id){
        return productService.findById(id);
    }

    @DeleteMapping("/remove")
    public String delete(@RequestParam Integer id){
        return  productService.delete(id);
    }

}
