package com.spring.redis.com.spring.redis.example.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("ProductModel")
public class ProductModel implements Serializable {
    @Id
    private int id;
    private String name;
    private int qty;
    private long price;
}
