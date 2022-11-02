package com.example.csse_backend.service;
import com.example.csse_backend.entities.Product;
import com.example.csse_backend.repo.productRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private productRepo ProductRepo;

    public List<Product> listAll(){
        return ProductRepo.findAll();
    }

    public Product saveProduct(Product product){
        return ProductRepo.save(product);
    }

    public Product get(Integer id){
        return ProductRepo.findById(id).get();
    }

    public void delete(Integer id){
        ProductRepo.deleteById(id);
    }

    public String getProducts(){
        return listAll().toString();
    }


}
