package com.example.csse_backend;

import com.example.csse_backend.entities.Product;
import com.example.csse_backend.repo.productRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProductUnitTest {

    @Autowired
    private productRepo ProductRepo;

    public Product addProduct(Product product){
        return ProductRepo.save(product);
    }
}
