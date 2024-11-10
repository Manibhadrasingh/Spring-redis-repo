package com.spring.redis.com.spring.redis.example.repo;

import com.spring.redis.com.spring.redis.example.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepo {

    @Value("${redis.hash.key}")
    private String HASH_KEY;

    @Autowired
    private RedisTemplate redisTemplate;

    public ProductModel save(ProductModel productModel){
        redisTemplate.opsForHash().put(HASH_KEY,productModel.getId(),productModel);
        return productModel;
    }

    public List<ProductModel> findAll(){
       return (List<ProductModel>) redisTemplate.opsForHash().values(HASH_KEY);

    }

    public ProductModel findById(Integer id){
        System.out.println("called findById from DB");
       return (ProductModel) redisTemplate.opsForHash().get(HASH_KEY,id);
    }

    public String deleteProduct(Integer id){
        redisTemplate.opsForHash().delete(HASH_KEY,id);
        return  "Product removed !";
    }
}
