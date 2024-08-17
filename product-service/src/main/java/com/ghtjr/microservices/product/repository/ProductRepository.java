package com.ghtjr.microservices.product.repository;

import com.ghtjr.microservices.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
